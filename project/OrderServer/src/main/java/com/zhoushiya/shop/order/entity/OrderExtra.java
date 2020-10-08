package com.zhoushiya.shop.order.entity;

import com.zhoushiya.shop.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单额外信息
 * @author zhoushiya
 * @date 2020/10/8 18:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExtra implements BaseEntity {
    /**
     * 订单Id
     */
    private long orderId;
    private String address;
    private String buyer;
    private long mobile;
    private int statusId;
}
