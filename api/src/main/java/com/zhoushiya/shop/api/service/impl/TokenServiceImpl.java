package com.zhoushiya.shop.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhoushiya.shop.api.config.ShopConfiguration;
import com.zhoushiya.shop.api.entity.ShopAdmin;
import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.service.ITokenService;
import org.springframework.stereotype.Service;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:20
 */
@Service(value="tokenService")
public class TokenServiceImpl implements ITokenService {
    /**
     * 常量，用户Token中保存信息的前缀
     */
    final String USER_TOKEN_PREFIX="USER_";
    /**
     * 常量，管理员Token中保存信息的前缀
     */
    final String ADMIN_TOKEN_PREFIX="ADMIN_";

    @Override
    public String getUserToken(ShopUser shopUser) {
        return JWT.create().withAudience(USER_TOKEN_PREFIX,shopUser.getId().toString()) // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(ShopConfiguration.USER_TOKEN_ENCRYPT_KEY));
    }

    @Override
    public String getAdminToken(ShopAdmin shopAdmin) {
        return JWT.create().withAudience(ADMIN_TOKEN_PREFIX,shopAdmin.getId().toString()) // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(ShopConfiguration.ADMIN_TOKEN_ENCRYPT_KEY));
    }
}
