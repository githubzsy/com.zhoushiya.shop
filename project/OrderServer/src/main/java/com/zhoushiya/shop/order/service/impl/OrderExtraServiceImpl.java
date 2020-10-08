package com.zhoushiya.shop.order.service.impl;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.order.config.OrderStatus;
import com.zhoushiya.shop.order.dao.OrderExtraDao;
import com.zhoushiya.shop.order.entity.OrderExtra;
import com.zhoushiya.shop.order.service.OrderExtraService;
import com.zhoushiya.shop.order.vo.OrderExtraVO;
import org.springframework.stereotype.Service;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:49
 */
@Service
public class OrderExtraServiceImpl extends BaseServiceImpl<OrderExtra, OrderExtraVO> implements OrderExtraService {

    private final OrderExtraDao orderExtraDao;

    public OrderExtraServiceImpl(OrderExtraDao orderExtraDao) {
        this.orderExtraDao = orderExtraDao;
    }

    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public BaseDao<OrderExtra> getCurrentDao() {
        return orderExtraDao;
    }

    /**
     * 修改订单状态
     *
     * @param orderStatus 订单状态
     * @param orderId     订单号
     */
    @Override
    public void changeStatus(long orderId, OrderStatus orderStatus) {
        orderExtraDao.changeStatus(orderId, orderStatus.getKey());
    }
}
