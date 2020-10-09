package com.zhoushiya.shop.gateway.filter;

import com.zhoushiya.shop.common.vo.CommonResult;
import com.zhoushiya.shop.gateway.config.GatewayNacosConfig;
import com.zhoushiya.shop.gateway.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

/**
 * @author zhoushiya
 * @date 2020/9/29 19:59
 */
@Component
@RefreshScope
public class GatewayFilter implements GlobalFilter, Ordered {

    private final AuthService authService;

    private final GatewayNacosConfig gatewayNacosConfig;

    public GatewayFilter(AuthService authService, GatewayNacosConfig gatewayNacosConfig) {
        this.authService = authService;
        this.gatewayNacosConfig = gatewayNacosConfig;
    }

    /**
     * @param exchange 封装了request和response
     * @param chain    调用链
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        // 0:还未认证,1:有权限,2:无权限
        byte adminVerify = 0;

        for (String url : gatewayNacosConfig.getAdminFilterUrls()) {
            // 如果该网络路径需要管理员身份认证
            if (Pattern.matches(url, path)) {
                switch (adminVerify) {
                    // 当前请求暂未认证管理员身份
                    case 0:
                        // 则进行认证
                        if (filter(exchange, "admin_token", "admin_id", authService::adminVerify)) {
                            // 认证通过
                            adminVerify = 1;
                        } else {
                            // 认证未通过
                            adminVerify = 2;
                            return exchange.getResponse().setComplete();
                        }
                        break;
                    // 当前请求已经认证管理员身份成功
                    case 1:
                        break;
                    // 否则就是认证管理员身份失败
                    default:
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                }
            }
        }

        byte userVerify = 0;

        for (String url : gatewayNacosConfig.getUserFilterUrls()) {
            // 如果该网络路径需要管理员身份认证
            if (Pattern.matches(url, path)) {
                switch (userVerify) {
                    case 0:
                        if (filter(exchange, "user_token", "user_id", authService::userVerify)) {
                            userVerify = 1;
                        } else {
                            userVerify = 2;
                            return exchange.getResponse().setComplete();
                        }
                        break;
                    case 1:
                        break;
                    default:
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                }
            }
        }

        return chain.filter(exchange);
    }

    /**
     * 验证是否有管理员权限
     *
     * @param exchange
     * @return
     */
    private boolean filter(ServerWebExchange exchange, String tokenHeaderName, String idHeaderName, BiFunction<Long, String, ResponseEntity<CommonResult>> biFunction) {
        String token = exchange.getRequest().getHeaders().getFirst(tokenHeaderName);
        String id = exchange.getRequest().getHeaders().getFirst(idHeaderName);
        if (StringUtils.isBlank(token) || StringUtils.isBlank(id)) {
            // 设置未授权
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            // 退出
            return false;
        } else {
            ResponseEntity<CommonResult> result = biFunction.apply(Long.decode(id), token);
            exchange.getResponse().setStatusCode(result.getStatusCode());
            if (result.getStatusCode() != HttpStatus.OK) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
