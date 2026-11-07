package com.cause.dao;

import com.cause.domain.DemoItem;
import com.simple.common.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * {@code demo_item} 数据访问。单表能力来自 SimpleDAO {@link BaseDao}。
 */
@Repository
public class DemoItemDao extends BaseDao<DemoItem> {

    public List<DemoItem> listActive() {
        return list(new DemoItemCond());
    }
}
