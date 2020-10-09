package com.zhoushiya.shop.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhoushiya
 * @date 2020/10/9 14:23
 */
@Data
@ConfigurationProperties(prefix = "config")
public class GatewayNacosConfig {
    private String[] adminFilterUrls;
    private String[] userFilterUrls;
}
