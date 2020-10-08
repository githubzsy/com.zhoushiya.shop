package com.zhoushiya.shop.product.vo;

import com.zhoushiya.shop.common.vo.BaseVOWithIdImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO extends BaseVOWithIdImpl {
    private String name;
    private long typeId;
    private String description;
    private BigDecimal price;
    private int stock;
}
