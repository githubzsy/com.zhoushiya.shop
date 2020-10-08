package com.zhoushiya.shop.order.entity;

import com.zhoushiya.shop.common.entity.BaseEntityWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhoushiya
 * @date 2020/10/8 18:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntityWithId {
    private long productId;
    private int count;
    private BigDecimal totalPrice;
    private long userId;
    private Date orderTime;
}
