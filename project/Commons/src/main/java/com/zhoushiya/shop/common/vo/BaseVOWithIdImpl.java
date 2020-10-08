package com.zhoushiya.shop.common.vo;

import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.entity.BaseEntityWithId;

/**
 * @author zhoushiya
 * @date 2020/10/8 13:15
 */
public abstract class BaseVOWithIdImpl extends BaseVOImpl {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public void afterCreateSuccess(BaseEntityWithId entity) {
        super.afterCreateSuccess(entity);
        this.setId(entity.getId());
    }
}
