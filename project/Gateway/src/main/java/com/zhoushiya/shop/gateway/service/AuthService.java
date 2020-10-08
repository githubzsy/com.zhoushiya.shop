package com.zhoushiya.shop.gateway.service;

import com.zhoushiya.shop.common.vo.CommonResult;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhoushiya
 * @date 2020/10/7 16:44
 */
@FeignClient("auth-server")
public interface AuthService {
    /**
     * 验证是否为管理员
     * @param id
     * @param token
     * @return
     */
    @GetMapping("/auth/admin/verify/{id}/{token}")
    @Cacheable(value="adminVerify",key = "#p0+#p1")
    ResponseEntity<CommonResult> adminVerify(@PathVariable("id") long id, @PathVariable("token") String token);
}
