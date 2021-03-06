package com.zhoushiya.shop.gateway;

import com.zhoushiya.shop.gateway.config.GatewayNacosConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhoushiya
 * @date 2020/10/6 12:46
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GatewayNacosConfig.class)
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
