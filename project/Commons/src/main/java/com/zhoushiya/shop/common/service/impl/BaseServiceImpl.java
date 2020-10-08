package com.zhoushiya.shop.common.service.impl;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.service.BaseService;
import com.zhoushiya.shop.common.utils.DozerUtils;
import com.zhoushiya.shop.common.vo.BaseVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:45
 */
public abstract class BaseServiceImpl<Entity extends BaseEntity,VO extends BaseVO> implements BaseService<VO> {

    @Autowired
    protected Mapper mapper;

    /**
     * Entity的实际类型
     */
    final Class<Entity> entityClass = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /**
     * VO的实际类型
     */
    final Class<VO> voClass = (Class<VO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];


    /**
     * 获取当前使用的实际Dao
     * @return 实际Dao
     */
    public abstract BaseDao<Entity> getCurrentDao();

    @Override
    public void create(VO vo) {
        Entity entity = mapper.map(vo, entityClass);
        getCurrentDao().create(entity);
        vo.afterCreateSuccess(entity);
    }

    @Override
    public void update(VO vo) {
        Entity entity = mapper.map(vo, entityClass);
        getCurrentDao().updateByPrimaryKey(entity);
    }

    @Override
    public VO getById(long id) {
        Entity entity = getCurrentDao().selectByPrimaryKey(id);
        VO vo = mapper.map(entity, voClass);
        return vo;
    }

    @Override
    public void deleteById(long id) {
        getCurrentDao().deleteByPrimaryKey(id);
    }

    @Override
    public List<VO> list() {
        return DozerUtils.mapList(getCurrentDao().list(), voClass);
    }
}
