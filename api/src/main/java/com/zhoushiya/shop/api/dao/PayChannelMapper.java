package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.PayChannel;

public interface PayChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayChannel record);

    int insertSelective(PayChannel record);

    PayChannel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayChannel record);

    int updateByPrimaryKey(PayChannel record);
}