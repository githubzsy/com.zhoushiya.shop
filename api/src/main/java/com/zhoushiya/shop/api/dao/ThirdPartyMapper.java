package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.ThirdParty;

public interface ThirdPartyMapper {
    int insert(ThirdParty record);

    int insertSelective(ThirdParty record);
}