package com.zhoushiya.shop.gateway.filter;

import com.zhoushiya.shop.common.vo.CommonResult;
import com.zhoushiya.shop.gateway.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhoushiya
 * @date 2020/9/29 19:59
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    private final AuthService authService;

    public GatewayFilter(AuthService authService) {
        this.authService = authService;
    }

    /**
     *
     * @param exchange 封装了request和response
     * @param chain 调用链
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if(exchange.getRequest().getURI().getPath().startsWith("/admin/")){
            String admin_token = exchange.getRequest().getHeaders().getFirst("admin_token");
            String admin_id = exchange.getRequest().getHeaders().getFirst("admin_id");
            if(StringUtils.isBlank(admin_token) || StringUtils.isBlank(admin_id)){
                // 设置未授权
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                // 退出
                return exchange.getResponse().setComplete();
            }
            else{
                ResponseEntity<CommonResult> result = authService.adminVerify(Long.parseLong(admin_id), admin_token);
                exchange.getResponse().setStatusCode(result.getStatusCode());
                if(result.getStatusCode()!=HttpStatus.OK){
                    return exchange.getResponse().setComplete();
                }
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
