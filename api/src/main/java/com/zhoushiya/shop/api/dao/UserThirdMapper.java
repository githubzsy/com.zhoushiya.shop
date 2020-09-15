package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.UserThird;

public interface UserThirdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserThird record);

    int insertSelective(UserThird record);

    UserThird selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserThird record);

    int updateByPrimaryKey(UserThird record);
}