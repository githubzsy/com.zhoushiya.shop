package com.zhoushiya.shop.api.vo;

/**
 * 封装前端登录的信息
 * @author zhoushiya
 * @date 2020/8/30 16:04
 */
public class LoginParam {
    public LoginParam() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String account;

    private String password;
}
