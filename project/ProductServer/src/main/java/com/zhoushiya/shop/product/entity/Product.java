package com.zhoushiya.shop.product.entity;

import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.entity.BaseEntityWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhoushiya
 * @date 2020/10/8 10:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntityWithId {
    private String name;
    private long typeId;
    private String description;
    private BigDecimal price;
}
