package com.zhoushiya.shop.common.entity;

/**
 * @author zhoushiya
 * @date 2020/10/8 13:14
 */
public abstract class BaseEntityWithId implements BaseEntity {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
