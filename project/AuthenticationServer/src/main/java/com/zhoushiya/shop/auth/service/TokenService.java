package com.zhoushiya.shop.auth.service;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:10
 */
public interface TokenService {
    /**
     * 获取用户登录后的Token
     * @param id 用户实体
     * @return
     */
    String getUserToken(long id);

    /**
     * 获取管理员登录后的Token
     * @param id 管理员实体
     * @return
     */
    String getAdminToken(long id);
}
