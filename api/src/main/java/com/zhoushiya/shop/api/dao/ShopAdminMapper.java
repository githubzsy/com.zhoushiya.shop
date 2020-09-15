package com.zhoushiya.shop.api.dao;

import com.zhoushiya.shop.api.entity.ShopAdmin;
import com.zhoushiya.shop.api.vo.LoginParam;

public interface ShopAdminMapper extends BaseMapper<ShopAdmin> {
    ShopAdmin selectByAccountAndPassword(LoginParam loginParam);
}