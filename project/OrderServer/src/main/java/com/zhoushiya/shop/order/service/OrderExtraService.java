package com.zhoushiya.shop.order.service;

import com.zhoushiya.shop.common.service.BaseService;
import com.zhoushiya.shop.order.config.OrderStatus;
import com.zhoushiya.shop.order.vo.OrderExtraVO;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:46
 */
public interface OrderExtraService extends BaseService<OrderExtraVO> {
    /**
     * 修改订单状态
     * @param orderStatus 订单状态
     */
    void changeStatus(long orderId, OrderStatus orderStatus);
}
