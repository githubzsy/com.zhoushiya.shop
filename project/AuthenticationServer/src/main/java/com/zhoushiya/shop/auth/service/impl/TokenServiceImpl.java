package com.zhoushiya.shop.auth.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zhoushiya.shop.auth.config.JWTConfig;
import com.zhoushiya.shop.auth.service.TokenService;
import org.springframework.stereotype.Service;

import static com.zhoushiya.shop.auth.config.JWTConfig.ADMIN_TOKEN_ENCRYPT_KEY;
import static com.zhoushiya.shop.auth.config.JWTConfig.USER_TOKEN_ENCRYPT_KEY;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:20
 */
@Service(value = "shopTokenService")
public class TokenServiceImpl implements TokenService {


    @Override
    public String getUserToken(long id) {
        return JWT.create().withAudience(JWTConfig.USER_TOKEN_PREFIX,String.valueOf(id)) // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(USER_TOKEN_ENCRYPT_KEY));
    }

    @Override
    public String getAdminToken(long id) {
        return JWT.create().withAudience(JWTConfig.ADMIN_TOKEN_PREFIX,String.valueOf(id)) // 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(ADMIN_TOKEN_ENCRYPT_KEY));
    }
}
