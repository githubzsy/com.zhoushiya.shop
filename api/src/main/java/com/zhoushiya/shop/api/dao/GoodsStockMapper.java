package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.GoodsStock;

public interface GoodsStockMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsStock record);

    int insertSelective(GoodsStock record);

    GoodsStock selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(GoodsStock record);

    int updateByPrimaryKey(GoodsStock record);
}