package com.zhoushiya.shop.api.service;

import com.zhoushiya.shop.api.entity.ShopAdmin;
import com.zhoushiya.shop.api.vo.LoginParam;
import com.zhoushiya.shop.api.vo.ShopAdminVO;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:30
 */
public interface IShopAdminService extends IBaseService<ShopAdminVO> {

    ShopAdmin login(LoginParam loginParam);
}
