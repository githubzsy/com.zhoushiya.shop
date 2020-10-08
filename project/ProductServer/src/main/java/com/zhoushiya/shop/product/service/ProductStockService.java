package com.zhoushiya.shop.product.service;

import com.zhoushiya.shop.common.service.BaseService;
import com.zhoushiya.shop.product.entity.ProductStock;
import com.zhoushiya.shop.product.vo.ProductStockVO;

import java.math.BigDecimal;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:25
 */
public interface ProductStockService extends BaseService<ProductStockVO> {
    /**
     * 减少库存
     * @param productId 产品Id
     * @param count 减少的数量
     */
    BigDecimal decrease(long productId, int count);
}
