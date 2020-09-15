package com.zhoushiya.shop.api.service;

import com.zhoushiya.shop.api.vo.BaseVO;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/8/25 23:02
 */
public interface IBaseService<VO extends BaseVO> {
    /**
     * 插入数据
     * @param vo
     * @return
     */
    VO insert(VO vo);

    /**
     * 更新数据
     * @param vo
     * @return
     */
    VO update(VO vo);

    /**
     * 寻找数据
     * @param id
     * @return
     */
    VO getById(Integer id);

    /**
     * 删除数据
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有数据
     * @return
     */
    List<VO> list();
}
