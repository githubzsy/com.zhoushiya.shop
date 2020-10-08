package com.zhoushiya.shop.product.controller;

import com.zhoushiya.shop.common.vo.CommonResult;
import com.zhoushiya.shop.product.vo.ProductVO;
import com.zhoushiya.shop.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:14
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public long create(@RequestBody ProductVO productVO){
        productService.create(productVO);
        return productVO.getId();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id){
        productService.deleteById(id);
    }

    @GetMapping("/getAll")
    public List<ProductVO> getAll(){
        return productService.list();
    }

    @GetMapping("/{id}")
    public ProductVO getById(@PathVariable long id){
        return productService.getById(id);
    }

}
