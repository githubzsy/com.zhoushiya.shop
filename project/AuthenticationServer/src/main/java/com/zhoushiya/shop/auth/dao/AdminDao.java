package com.zhoushiya.shop.auth.dao;


import com.zhoushiya.shop.auth.entity.Admin;
import com.zhoushiya.shop.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminDao extends BaseDao<Admin> {
    Admin selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);
}