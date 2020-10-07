package com.zhoushiya.shop.auth.service.impl;

import com.zhoushiya.shop.auth.dao.UserDao;
import com.zhoushiya.shop.auth.entity.User;
import com.zhoushiya.shop.auth.service.UserService;
import com.zhoushiya.shop.auth.vo.RegisterInfo;
import com.zhoushiya.shop.auth.vo.UserVO;
import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.common.utils.DozerUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhoushiya
 * @date 2020/10/7 12:09
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserVO> implements UserService  {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public UserVO selectByAccountAndPassword(String account, String password) {
        User user = userDao.selectByAccountAndPassword(account, password);
        return DozerUtils.mapper.map(user,UserVO.class);
    }

    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public BaseDao<User> getCurrentDao() {
        return userDao;
    }

    /**
     * 不能调用此方法，请调用{@code create(RegisterInfo info)}
     * @param vo
     */
    @Deprecated
    @Override
    public void create(UserVO vo) {
        throw new RuntimeException("不能调用此方法，请调用create(RegisterInfo info)方法");
    }

    @Override
    public long create(RegisterInfo info){
        User user = DozerUtils.mapper.map(info, User.class);
        userDao.create(user);
        return user.getId();
    }
}
