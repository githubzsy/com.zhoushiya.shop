package com.zhoushiya.shop.user.service.impl;

import com.zhoushiya.shop.user.dao.UserDao;
import com.zhoushiya.shop.user.entity.User;
import com.zhoushiya.shop.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/6 14:49
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 创建一个用户
     *
     * @param user
     * @return 创建后的用户信息
     */
    @Override
    public User create(User user) {
        userDao.create(user);
        return user;
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    /**
     * 删除用户
     *
     * @param id
     */
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    /**
     * 获取所有用户
     */
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
