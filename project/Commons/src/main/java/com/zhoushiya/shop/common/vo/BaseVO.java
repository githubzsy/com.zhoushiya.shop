package com.zhoushiya.shop.common.vo;

import com.zhoushiya.shop.common.entity.BaseEntity;

/**
 * @author zhoushiya
 * @date 2020/8/26 20:04
 */
public interface BaseVO<Entity extends BaseEntity>{
    void afterCreateSuccess(Entity entity);
}
