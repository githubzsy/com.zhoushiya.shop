package com.zhoushiya.shop.api.service;

import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.entity.ShopAdmin;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:10
 */
public interface ITokenService {
    /**
     * 获取用户登录后的Token
     * @param shopUser 用户实体
     * @return
     */
    public String getUserToken(ShopUser shopUser);

    /**
     * 获取管理员登录后的Token
     * @param shopAdmin 管理员实体
     * @return
     */
    public String getAdminToken(ShopAdmin shopAdmin);
}
