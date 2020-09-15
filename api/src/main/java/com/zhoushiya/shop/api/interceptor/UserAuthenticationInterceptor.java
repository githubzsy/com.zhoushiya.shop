package com.zhoushiya.shop.api.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhoushiya.shop.api.annotation.UserLoginToken;
import com.zhoushiya.shop.api.config.ShopConfiguration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * 用户验证拦截器
 */
public class UserAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("user_token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
                try {
                    JWT.decode(token);
                } catch (JWTDecodeException j) {
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }

                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ShopConfiguration.USER_TOKEN_ENCRYPT_KEY)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
            }
        }
        return true;
    }
}
