package com.zhoushiya.shop.order.config;

import com.zhoushiya.shop.common.utils.BaseEnum;

/**
 * 枚举订单状态
 * @author zhoushiya
 * @date 2020/10/8 18:56
 */
public enum OrderStatus implements BaseEnum {

    /**
     * 已下单
     */
    ORDERED(0,"已下单"),
    /**
     * 已支付
     */
    PAID(11,"已支付"),
    /**
     * 已完成
     */
    COMPLETED(21,"已完成");


    /**
     * 状态Id
     */
    private final int statusId;

    /**
     * 描述
     */
    private final String description;
    OrderStatus(int statusId,String description){
        this.statusId=statusId;
        this.description=description;
    }

    @Override
    public Integer getKey() {
        return this.statusId;
    }
}
