package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.OrderExtra;

public interface OrderExtraMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderExtra record);

    int insertSelective(OrderExtra record);

    OrderExtra selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderExtra record);

    int updateByPrimaryKey(OrderExtra record);
}