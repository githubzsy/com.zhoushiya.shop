package com.zhoushiya.shop.common.service;

import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.vo.BaseVO;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:43
 */
public interface BaseService<VO extends BaseVO> {
    /**
     * 插入数据
     * @param vo
     * @return
     */
    void create(VO vo);

    /**
     * 更新数据
     * @param vo
     * @return
     */
    void update(VO vo);

    /**
     * 寻找数据
     * @param id
     * @return
     */
    VO getById(long id);

    /**
     * 删除数据
     * @param id
     * @return
     */
    void deleteById(long id);

    /**
     * 查询所有数据
     * @return
     */
    List<VO> list();
}
