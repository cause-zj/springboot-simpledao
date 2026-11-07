# springboot-simpledao

最小 Spring Boot 示例：用 [SimpleDAO](https://github.com/gzz2017gzz/simple-dao) 做单表访问。SimpleDAO 建在 Spring JDBC 上，本仓库不使用 MyBatis-Plus，也不引入第二套 ORM。

## 版本

| 项 | 值 |
| --- | --- |
| Spring Boot | `spring-boot-starter-parent` **3.5.16** |
| Java | **21**（`java.version`） |
| 坐标 | `com.cause:springboot-simpledao` |
| SimpleDAO | `io.gitee.simpledao:simple-dao:1.2.0`（Maven Central） |
| 数据库驱动 | `mysql-connector-j`（runtime，版本由 Spring Boot 管理） |

## 代码布局

```
com.cause
├── Application
├── controller    HealthController、DemoItemController
├── service       DemoItemService
├── dao           DemoItemDao（继承 BaseDao）、DemoItemCond
└── domain        DemoItem（@Table / @Id）
```

`DemoItem` 对应表 `demo_item`。字段按 SimpleDAO 1.2.0 约定：主键 `id`（`@Id` 默认雪花）、业务字段 `name`，以及审计字段 `createTime` / `createBy` / `updateTime` / `updateBy` 和逻辑删除字段 `dr`。`DemoItemDao` 继承 `com.simple.common.base.BaseDao`，列表接口只返回 `dr = 0` 的行。

## 数据源

复用宿主机已经在跑的 MySQL，**不要**再起一个 MySQL 容器。

- Compose 目录：`~/dev-env/mysql-redis-kafka`
- 地址：`localhost:3306`
- 管理账号：`root` / `devroot`
- 应用账号：`app` / `app123`
- 专用库：`springboot_simpledao`（主机上已建好）
- 驱动：`com.mysql.cj.jdbc.Driver`
- URL：`jdbc:mysql://localhost:3306/springboot_simpledao?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true&useSSL=false`

`spring.sql.init.mode` 为 `always`。启动时执行 `schema.sql`（`CREATE TABLE IF NOT EXISTS demo_item`）和 `data.sql`（按主键幂等插入一条「示例条目」）。新克隆的环境也能把表建出来；表已存在时不会重复建表，种子数据也不会重复插入。

## 运行

```bash
mvn -DskipTests package
mvn spring-boot:run
```

或直接跑打包结果：

```bash
java -jar target/springboot-simpledao-0.0.1-SNAPSHOT.jar
```

默认端口 `8080`。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/api/ping` | `{"status":"ok"}` |
| GET | `/api/health` | `{"status":"UP","application":"springboot-simpledao"}` |
| GET | `/api/demo-items` | 通过 SimpleDAO 列出未删除的 `demo_item`；库里还没有数据时返回 `[]` |

```bash
curl -s http://localhost:8080/api/ping
curl -s http://localhost:8080/api/health
curl -s http://localhost:8080/api/demo-items
```

## 测试

```bash
mvn -B test
```

接口测试使用 `@WebMvcTest`，不连接 MySQL。连上本机库做一次手工验证时，先确认 `localhost:3306` 上的 `local-mysql` 可用，再用上面的 `mvn spring-boot:run`。
