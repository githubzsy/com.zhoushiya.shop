package com.zhoushiya.shop.product.vo;

import com.zhoushiya.shop.common.vo.BaseVO;
import com.zhoushiya.shop.common.vo.BaseVOImpl;
import com.zhoushiya.shop.product.entity.ProductStock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStockVO extends BaseVOImpl {
    private long productId;
    private int stock;
}
