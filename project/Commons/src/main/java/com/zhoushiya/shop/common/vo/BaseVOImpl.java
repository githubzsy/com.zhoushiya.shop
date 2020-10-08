package com.zhoushiya.shop.common.vo;

import com.zhoushiya.shop.common.entity.BaseEntityWithId;

/**
 * @author zhoushiya
 * @date 2020/10/8 15:27
 */
public abstract class BaseVOImpl<Entity extends BaseEntityWithId> implements BaseVO<Entity> {

    @Override
    public void afterCreateSuccess(Entity entity) {

    }
}
