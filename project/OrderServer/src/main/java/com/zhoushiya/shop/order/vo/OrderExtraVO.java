package com.zhoushiya.shop.order.vo;

import com.zhoushiya.shop.common.utils.EnumUtil;
import com.zhoushiya.shop.common.vo.BaseVOImpl;
import com.zhoushiya.shop.order.config.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExtraVO extends BaseVOImpl {
    private long orderId;
    private String address;
    private String buyer;
    private String mobile;
    private int statusId;
    private OrderStatus orderStatus;
    public OrderStatus getOrderStatus(){
        return EnumUtil.getByKey(this.statusId,OrderStatus.class);
    }
}
