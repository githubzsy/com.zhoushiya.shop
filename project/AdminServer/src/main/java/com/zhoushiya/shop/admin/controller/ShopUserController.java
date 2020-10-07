package com.zhoushiya.shop.admin.controller;

import com.zhoushiya.shop.admin.service.ShopUserService;
import com.zhoushiya.shop.common.vo.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理所有商城用户
 * @author zhoushiya
 * @date 2020/10/7 16:26
 */
@RestController
@RequestMapping("/admin/shopUser")
public class ShopUserController {

    private final ShopUserService shopUserService;

    public ShopUserController(ShopUserService shopUserService) {
        this.shopUserService = shopUserService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<CommonResult> getAllUser(){
        return new ResponseEntity<>(CommonResult.getOKResult(shopUserService.getAll()), HttpStatus.OK);
    }

}
