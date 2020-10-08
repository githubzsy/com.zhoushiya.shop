package com.zhoushiya.shop.order.vo;

import com.zhoushiya.shop.common.utils.EnumUtil;
import com.zhoushiya.shop.common.vo.BaseVOWithIdImpl;
import com.zhoushiya.shop.order.config.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhoushiya
 * @date 2020/10/8 18:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO extends BaseVOWithIdImpl {
    private long productId;
    private int count;
    private BigDecimal totalPrice;
    private long userId;
    private Date orderTime;
    private String address;
    private String buyer;
    private long mobile;
    private int statusId;
    private OrderStatus orderStatus;
    public OrderStatus getOrderStatus(){
        return EnumUtil.getByKey(this.statusId,OrderStatus.class);
    }
}
