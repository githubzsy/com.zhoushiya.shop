package com.zhoushiya.shop.admin.service.impl;

import com.zhoushiya.shop.admin.dao.ShopUserDao;
import com.zhoushiya.shop.admin.entity.ShopUser;
import com.zhoushiya.shop.admin.service.ShopUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/7 17:32
 */
@Service
public class ShopUserServiceImpl implements ShopUserService {

    private final ShopUserDao shopUserDao;

    public ShopUserServiceImpl(ShopUserDao shopUserDao) {
        this.shopUserDao = shopUserDao;
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public List<ShopUser> getAll() {
        return shopUserDao.getAll();
    }
}
