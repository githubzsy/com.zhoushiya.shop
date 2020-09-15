package com.zhoushiya.shop.api.controller;

import com.zhoushiya.shop.api.annotation.AdminLoginToken;
import com.zhoushiya.shop.api.service.IShopUserService;
import com.zhoushiya.shop.api.vo.ShopUserVO;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:07
 */
@RestController
@RequestMapping("/rest/admin")
@AdminLoginToken
public class AdminApi {
    final IShopUserService shopUserService;

    public AdminApi(IShopUserService shopUserService) {
        this.shopUserService = shopUserService;
    }

    @PutMapping("/user")
    public ShopUserVO insertUser(ShopUserVO vo){
        return shopUserService.insert(vo);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable int id){
        return shopUserService.deleteById(id);
    }

    @PostMapping("/user")
    public ShopUserVO updateUser(ShopUserVO vo){
        return shopUserService.update(vo);
    }

    @GetMapping("/user/{id}")
    public ShopUserVO getUser(@PathVariable int id){
        return shopUserService.getById(id);
    }
}
