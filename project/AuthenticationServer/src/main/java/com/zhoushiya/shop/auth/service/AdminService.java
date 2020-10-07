package com.zhoushiya.shop.auth.service;

import com.zhoushiya.shop.auth.entity.Admin;
import com.zhoushiya.shop.auth.vo.AdminVO;
import com.zhoushiya.shop.auth.vo.RegisterInfo;
import com.zhoushiya.shop.auth.vo.UserVO;
import com.zhoushiya.shop.common.service.BaseService;

/**
 * @author zhoushiya
 * @date 2020/10/7 12:16
 */
public interface AdminService extends BaseService<AdminVO> {
    AdminVO selectByAccountAndPassword(String account, String password);

    /**
     * 不能调用此方法，请调用 {@code AdminService.create(RegisterInfo info)}
     * @param vo
     * @return
     */
    @Deprecated
    @Override
    void create(AdminVO vo);

    /**
     * 创建一个用户信息
     * @param info 注册信息
     * @return
     */
    long create(RegisterInfo info);
}
