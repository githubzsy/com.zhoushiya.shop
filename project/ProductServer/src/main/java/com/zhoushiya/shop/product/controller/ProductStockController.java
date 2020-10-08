package com.zhoushiya.shop.product.controller;

import com.zhoushiya.shop.product.service.ProductStockService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author zhoushiya
 * @date 2020/10/8 12:32
 */
@RestController
@RequestMapping("/productStock")
public class ProductStockController {
    private final ProductStockService productStockService;

    public ProductStockController(ProductStockService productStockService) {
        this.productStockService = productStockService;
    }

    /**
     * 减少库存，返回总价
     * @param productId 商品Id
     * @param count 减少数量
     * @return
     */
    @PutMapping("/decrease/{productId}/{count}")
    public BigDecimal decrease(@PathVariable("productId") long productId, @PathVariable("count") int count){
        return productStockService.decrease(productId,count);
    }
}
