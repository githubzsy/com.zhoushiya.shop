package com.zhoushiya.shop.order.dao;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.order.entity.OrderExtra;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:20
 */
@Mapper
public interface OrderExtraDao extends BaseDao<OrderExtra> {
    /**
     * 修改订单状态
     * @param statusId
     */
    void changeStatus(@Param("order_id") long orderId,@Param("status_id") int statusId);
}
