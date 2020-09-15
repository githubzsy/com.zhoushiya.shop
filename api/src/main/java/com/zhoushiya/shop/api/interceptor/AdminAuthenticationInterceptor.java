package com.zhoushiya.shop.api.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhoushiya.shop.api.annotation.AdminLoginToken;
import com.zhoushiya.shop.api.config.ShopConfiguration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhoushiya
 * @date 2020/8/30 20:04
 */
public class AdminAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("admin_token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        Class<?> clazz = handlerMethod.getBean().getClass();

        //检查需不需要管理员权限
        if (clazz.isAnnotationPresent(AdminLoginToken.class) || method.isAnnotationPresent(AdminLoginToken.class)) {
            AdminLoginToken adminLoginToken = clazz.getAnnotation(AdminLoginToken.class);
            if (null == adminLoginToken) {
                adminLoginToken = method.getAnnotation(AdminLoginToken.class);
            }
            if (adminLoginToken.required()) {
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
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(ShopConfiguration.ADMIN_TOKEN_ENCRYPT_KEY)).build();
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
