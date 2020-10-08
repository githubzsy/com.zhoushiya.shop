package com.zhoushiya.shop.order.dao;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.order.config.OrderStatus;
import com.zhoushiya.shop.order.entity.Order;
import com.zhoushiya.shop.order.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 18:55
 */
@Mapper
public interface OrderDao extends BaseDao<Order> {
    OrderVO selectVOByPrimaryKey(long id);

    List<OrderVO> listVO();
}
