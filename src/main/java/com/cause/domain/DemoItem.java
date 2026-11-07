package com.cause.domain;

import com.simple.common.base.annotation.Id;
import com.simple.common.base.annotation.Table;

import java.time.LocalDateTime;

/**
 * 演示条目，对应表 {@code demo_item}。
 * {@code id} 默认雪花主键；{@code createTime}/{@code createBy}/{@code updateTime}/{@code updateBy}/{@code dr}
 * 按 SimpleDAO 1.2.0 约定由框架在写入时填充。
 */
@Table("demo_item")
public class DemoItem {

    @Id
    private Long id;
    private String name;
    private LocalDateTime createTime;
    private Long createBy;
    private LocalDateTime updateTime;
    private Long updateBy;
    private Byte dr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getDr() {
        return dr;
    }

    public void setDr(Byte dr) {
        this.dr = dr;
    }
}
