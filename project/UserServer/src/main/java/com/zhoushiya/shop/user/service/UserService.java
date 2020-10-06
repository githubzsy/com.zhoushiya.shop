package com.zhoushiya.shop.user.service;

import com.zhoushiya.shop.user.entity.User;

import java.util.List;

/**
 * 用户服务
 * @author zhoushiya
 * @date 2020/10/6 14:48
 */
public interface UserService {
    /**
     * 创建一个用户
     * @param user
     * @return 创建后的用户信息
     */
    User create(User user);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User getById(long id);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(long id);

    /**
     * 获取所有用户
     */
    List<User> getAll();
}
