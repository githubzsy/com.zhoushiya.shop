package com.zhoushiya.shop.api.config;


import com.zhoushiya.shop.api.interceptor.AdminAuthenticationInterceptor;
import com.zhoushiya.shop.api.interceptor.UserAuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jinbin
 * @date 2018-07-08 22:33
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthenticationInterceptor())
                .addPathPatterns("/**");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(adminAuthenticationInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public UserAuthenticationInterceptor userAuthenticationInterceptor() {
        return new UserAuthenticationInterceptor();
    }

    @Bean
    public AdminAuthenticationInterceptor adminAuthenticationInterceptor() {
        return new AdminAuthenticationInterceptor();
    }
}
