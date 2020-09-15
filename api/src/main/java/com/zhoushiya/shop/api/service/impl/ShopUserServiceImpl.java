package com.zhoushiya.shop.api.service.impl;

import com.zhoushiya.shop.api.dao.BaseMapper;
import com.zhoushiya.shop.api.dao.ShopUserMapper;
import com.zhoushiya.shop.api.entity.ShopUser;
import com.zhoushiya.shop.api.service.IShopUserService;
import com.zhoushiya.shop.api.vo.LoginParam;
import com.zhoushiya.shop.api.vo.ShopUserVO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author zhoushiya
 * @date 2020/8/25 23:43
 */
@Service(value = "shopUserService")
public class ShopUserServiceImpl extends BaseServiceImpl<ShopUser, ShopUserVO> implements IShopUserService {
    final ShopUserMapper shopUserMapper;

    public ShopUserServiceImpl(ShopUserMapper shopUserMapper) {
        this.shopUserMapper = shopUserMapper;
    }

    @Override
    BaseMapper<ShopUser> getShopUserMapper() {
        return shopUserMapper;
    }

    @Override
    public ShopUser login(LoginParam loginParam) {
        // 对密码进行md5加密
        loginParam.setPassword(DigestUtils.md5DigestAsHex(loginParam.getPassword().getBytes()));
        return shopUserMapper.selectByAccountAndPassword(loginParam);
    }
}
