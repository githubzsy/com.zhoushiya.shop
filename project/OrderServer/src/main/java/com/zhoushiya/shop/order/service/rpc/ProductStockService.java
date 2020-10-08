package com.zhoushiya.shop.order.service.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * 商品远程服务
 * @author zhoushiya
 * @date 2020/10/8 20:14
 */
@FeignClient("product-server")
@RequestMapping("/productStock")
public interface ProductStockService {
    @PutMapping("/decrease/{productId}/{count}")
    BigDecimal decrease(@PathVariable("productId") long productId, @PathVariable("count") int count);
}
