package com.zhoushiya.shop.common.vo;

/**
 * @author zhoushiya
 * @date 2020/8/26 20:04
 */
public abstract class BaseVO {
    public BaseVO() {
    }

    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
