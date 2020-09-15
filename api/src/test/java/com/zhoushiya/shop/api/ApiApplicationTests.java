package com.zhoushiya.shop.api;

import com.zhoushiya.shop.api.service.IShopUserService;
import com.zhoushiya.shop.api.vo.ShopUserVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiApplicationTests {

    @Resource
    IShopUserService userService;

    @Test
    public void insertTest() {
        ShopUserVO user = new ShopUserVO("lily","lily",18888888888l);
        userService.insert(user);
    }


    @Test
    public void getTest() {
        Assert.assertSame(1,userService.getById(1).getId());
    }

}
