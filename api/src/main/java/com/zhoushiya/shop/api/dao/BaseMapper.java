package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.BaseEntity;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/8/25 23:16
 */
public interface BaseMapper<Entity extends BaseEntity> {
    int deleteByPrimaryKey(Integer id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entity record);

    int updateByPrimaryKey(Entity record);

    List<Entity> list();
}
