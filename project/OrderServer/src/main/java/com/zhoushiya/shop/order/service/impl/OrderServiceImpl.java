package com.zhoushiya.shop.order.service.impl;

import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.order.config.OrderStatus;
import com.zhoushiya.shop.order.dao.OrderDao;
import com.zhoushiya.shop.order.dao.OrderExtraDao;
import com.zhoushiya.shop.order.entity.Order;
import com.zhoushiya.shop.order.entity.OrderExtra;
import com.zhoushiya.shop.order.service.OrderService;
import com.zhoushiya.shop.order.service.rpc.ProductStockService;
import com.zhoushiya.shop.order.vo.OrderVO;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:20
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderVO> implements OrderService {

    private final OrderDao orderDao;
    private final OrderExtraDao orderExtraDao;
    private final ProductStockService productStockService;

    public OrderServiceImpl(OrderDao orderDao, OrderExtraDao orderExtraDao, ProductStockService productStockService) {
        this.orderDao = orderDao;
        this.orderExtraDao = orderExtraDao;
        this.productStockService = productStockService;
    }

    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public OrderDao getCurrentDao() {
        return orderDao;
    }

    /**
     * 创建订单
     *
     * @param vo 订单信息
     * @return
     */
    @Override
    @GlobalTransactional
    @Transactional
    public void create(OrderVO vo) {
        // 减库存
        BigDecimal totalPrice = productStockService.decrease(vo.getProductId(), vo.getCount());
        vo.setTotalPrice(totalPrice);
        vo.setOrderStatus(OrderStatus.ORDERED);

        Order order = super.mapper.map(vo, Order.class);
        // 下单
        orderDao.create(order);
        vo.setId(order.getId());

        OrderExtra extra = super.mapper.map(vo, OrderExtra.class);
        extra.setOrderId(vo.getId());
        orderExtraDao.create(extra);
    }

    @Override
    public OrderVO getById(long id) {
        return orderDao.selectVOByPrimaryKey(id);
    }

    @Override
    public List<OrderVO> list() {
        return orderDao.listVO();
    }
}
