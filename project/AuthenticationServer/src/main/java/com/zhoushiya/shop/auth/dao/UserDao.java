package com.zhoushiya.shop.auth.dao;

import com.zhoushiya.shop.auth.entity.User;
import com.zhoushiya.shop.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:50
 */
@Mapper
public interface UserDao extends BaseDao<User> {
    /**
     * 根据账户和密码查找用户
     * @return
     */
    User selectByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}
