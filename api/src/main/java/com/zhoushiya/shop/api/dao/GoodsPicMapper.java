package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.GoodsPic;

public interface GoodsPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPic record);

    int insertSelective(GoodsPic record);

    GoodsPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPic record);

    int updateByPrimaryKey(GoodsPic record);
}