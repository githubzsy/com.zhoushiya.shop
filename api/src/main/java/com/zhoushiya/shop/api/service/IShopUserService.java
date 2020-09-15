package com.zhoushiya.shop.api.service;

import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.vo.LoginParam;
import com.zhoushiya.shop.api.vo.ShopUserVO;

/**
 * @author zhoushiya
 * @date 2020/8/25 22:54
 */
public interface IShopUserService extends IBaseService<ShopUserVO> {
    /**
     * 登录
     * @param loginParam 登录信息
     * @return 用户实体
     */
    ShopUser login(LoginParam loginParam);
}
