package com.zhoushiya.shop.api.controller;

import com.zhoushiya.shop.api.entity.ShopAdmin;
import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.service.IShopAdminService;
import com.zhoushiya.shop.api.service.IShopUserService;
import com.zhoushiya.shop.api.service.ITokenService;
import com.zhoushiya.shop.api.vo.LoginParam;
import com.zhoushiya.shop.api.vo.LoginResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoushiya
 * @date 2020/8/30 21:13
 */
@RestController
@RequestMapping("/rest/auth")
public class AuthApi {
    final IShopUserService shopUserService;

    final IShopAdminService shopAdminService;

    final ITokenService tokenService;

    final String LOGIN_FAILED_RESULT = "账号或密码错误";

    public AuthApi(IShopUserService shopUserService, IShopAdminService shopAdminService, ITokenService tokenService) {
        this.shopUserService = shopUserService;
        this.shopAdminService = shopAdminService;
        this.tokenService = tokenService;
    }

    @PostMapping("/user/login")
    public LoginResult userLogin(LoginParam loginParam) {
        ShopUser shopUser = shopUserService.login(loginParam);
        if (shopUser == null) {
            return LoginResult.CreateFailedResult(LOGIN_FAILED_RESULT);
        } else {
            String userToken = tokenService.getUserToken(shopUser);
            return LoginResult.CreateSuccessResult(userToken);
        }
    }

    @PostMapping("/admin/login")
    public LoginResult adminLogin(LoginParam loginParam) {
        ShopAdmin shopAdmin = shopAdminService.login(loginParam);
        if (shopAdmin == null) {
            return LoginResult.CreateFailedResult(LOGIN_FAILED_RESULT);
        } else {
            String token = tokenService.getAdminToken(shopAdmin);
            return LoginResult.CreateSuccessResult(token);
        }
    }
}
