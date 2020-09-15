package com.zhoushiya.shop.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author zhoushiya
 * @date 2020/8/26 20:04
 */
public abstract class BaseVO {
    public BaseVO() {
    }

    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
