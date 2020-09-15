package com.zhoushiya.shop.api.service.impl;

import com.zhoushiya.shop.api.dao.BaseMapper;
import com.zhoushiya.shop.api.dao.ShopAdminMapper;
import com.zhoushiya.shop.api.entity.ShopAdmin;
import com.zhoushiya.shop.api.service.IShopAdminService;
import com.zhoushiya.shop.api.vo.LoginParam;
import com.zhoushiya.shop.api.vo.ShopAdminVO;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author zhoushiya
 * @date 2020/8/30 21:59
 */
@Service(value = "shopAdminService")
public class ShopAdminServiceImpl extends BaseServiceImpl<ShopAdmin, ShopAdminVO> implements IShopAdminService {
    final ShopAdminMapper shopAdminMapper;

    public ShopAdminServiceImpl(ShopAdminMapper shopAdminMapper) {
        this.shopAdminMapper = shopAdminMapper;
    }

    @Override
    public ShopAdmin login(LoginParam loginParam) {
        // 对密码进行md5加密
        loginParam.setPassword(DigestUtils.md5DigestAsHex(loginParam.getPassword().getBytes()));
        return shopAdminMapper.selectByAccountAndPassword(loginParam);
    }

    @Override
    BaseMapper<ShopAdmin> getShopUserMapper() {
        return shopAdminMapper;
    }
}
