package com.cause.dao;

import com.simple.common.base.BaseCondition;

/**
 * {@code demo_item} 查询条件。未删除行 {@code dr = 0}。
 */
public class DemoItemCond extends BaseCondition {

    private final Byte dr;

    public DemoItemCond() {
        this.dr = (byte) 0;
    }

    @Override
    protected void addCondition() {
        and("dr =", dr);
    }
}
