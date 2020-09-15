package com.zhoushiya.shop.api.service.impl;

import com.zhoushiya.shop.api.dao.BaseMapper;
import com.zhoushiya.shop.api.entity.BaseEntity;
import com.zhoushiya.shop.api.service.IBaseService;
import com.zhoushiya.shop.api.utils.DozerUtils;
import com.zhoushiya.shop.api.vo.BaseVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @param <Entity> 实体类型
 * @param <VO>     展示类型
 * @author zhoushiya
 * @date 2020/8/25 23:12
 */
public abstract class BaseServiceImpl<Entity extends BaseEntity, VO extends BaseVO> implements IBaseService<VO> {

    @Autowired
    Mapper mapper;

    /**
     * Entity的实际类型
     */
    final Class<Entity> entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /**
     * VO的实际类型
     */
    final Class<VO> voClass = (Class<VO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

    /**
     * 获取当前使用的实际Mapper
     * @return 实际Mapper
     */
    abstract BaseMapper<Entity> getShopUserMapper();

    @Override
    public VO insert(VO vo) {
        Entity entity = mapper.map(vo, entityClass);
        getShopUserMapper().insert(entity);
        vo.setId(entity.getId());
        return vo;
    }

    @Override
    public VO update(VO vo) {
        Entity entity = mapper.map(vo, entityClass);
        getShopUserMapper().updateByPrimaryKey(entity);
        return vo;
    }

    @Override
    public VO getById(Integer id) {
        Entity entity = getShopUserMapper().selectByPrimaryKey(id);
        VO vo = mapper.map(entity, voClass);
        return vo;
    }

    @Override
    public boolean deleteById(Integer id) {
        getShopUserMapper().deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public List<VO> list() {
        return DozerUtils.mapList(getShopUserMapper().list(), voClass);
    }
}
