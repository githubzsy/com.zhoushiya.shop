package com.zhoushiya.shop.admin.service;

import com.zhoushiya.shop.admin.entity.ShopUser;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/7 17:26
 */
public interface ShopUserService {
    /**
     * 获取所有用户
     * @return
     */
    List<ShopUser> getAll();
}
