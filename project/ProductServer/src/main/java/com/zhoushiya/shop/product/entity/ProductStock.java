package com.zhoushiya.shop.product.entity;

import com.zhoushiya.shop.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock implements BaseEntity {
    private long productId;
    private int stock;
}
