package com.zhoushiya.shop.auth.service.impl;

import com.zhoushiya.shop.auth.dao.AdminDao;
import com.zhoushiya.shop.auth.entity.Admin;
import com.zhoushiya.shop.auth.entity.User;
import com.zhoushiya.shop.auth.service.AdminService;
import com.zhoushiya.shop.auth.vo.AdminVO;
import com.zhoushiya.shop.auth.vo.RegisterInfo;
import com.zhoushiya.shop.auth.vo.UserVO;
import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.common.utils.DozerUtils;
import org.springframework.stereotype.Service;

/**
 * @author zhoushiya
 * @date 2020/10/7 12:17
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminVO> implements AdminService {

    private final AdminDao adminDao;

    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public BaseDao<Admin> getCurrentDao() {
        return adminDao;
    }

    @Override
    public AdminVO selectByAccountAndPassword(String account, String password) {
        return DozerUtils.mapper.map(adminDao.selectByAccountAndPassword(account,password),AdminVO.class);
    }

    /**
     * 不能调用此方法，请调用{@code create(RegisterInfo info)}
     * @param vo
     */
    @Deprecated
    @Override
    public void create(AdminVO vo) {
        throw new RuntimeException("不能调用此方法，请调用create(RegisterInfo info)方法");
    }

    /**
     * 创建管理员
     * @param info 注册信息
     * @return
     */
    @Override
    public long create(RegisterInfo info){
        Admin admin = DozerUtils.mapper.map(info, Admin.class);
        adminDao.create(admin);
        return admin.getId();
    }
}
