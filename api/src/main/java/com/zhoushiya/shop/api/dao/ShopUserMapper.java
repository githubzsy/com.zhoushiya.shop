package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.vo.LoginParam;

public interface ShopUserMapper extends BaseMapper<ShopUser> {
    /**
     * 根据账户和密码查找用户
     * @param loginParam 登录信息
     * @return
     */
    ShopUser selectByAccountAndPassword(LoginParam loginParam);
}