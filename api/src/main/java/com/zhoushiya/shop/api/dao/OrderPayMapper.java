package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.OrderPay;

public interface OrderPayMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderPay record);

    int insertSelective(OrderPay record);

    OrderPay selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderPay record);

    int updateByPrimaryKey(OrderPay record);
}