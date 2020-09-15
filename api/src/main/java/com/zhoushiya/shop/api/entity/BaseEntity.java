package com.zhoushiya.shop.api.entity;

/**
 * @author zhoushiya
 * @date 2020/8/26 20:06
 */
public abstract class BaseEntity {
    public BaseEntity() {
    }

    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
