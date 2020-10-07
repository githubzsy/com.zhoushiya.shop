package com.zhoushiya.shop.common.dao;

import com.zhoushiya.shop.common.entity.BaseEntity;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:43
 */
public interface BaseDao<Entity extends BaseEntity> {
    int deleteByPrimaryKey(long id);

    int create(Entity record);

    Entity selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Entity record);

    List<Entity> list();
}

