package com.zhoushiya.shop.api.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录结果类
 * @author zhoushiya
 * @date 2020/8/30 15:31
 */
@Data
@NoArgsConstructor
public class LoginResult {
    /**
     * 0，失败
     * 1，成功
     */
    Integer loginResult;

    /**
     * 具体信息
     */
    String message;

    private LoginResult(Integer loginResult,String message){
        this.loginResult=loginResult;
        this.message=message;
    }

    /**
     * 获取一个登录失败的返回消息
     * @param message 登录失败的消息
     * @return
     */
    public static LoginResult CreateFailedResult(String message){
        return new LoginResult(0,message);
    }

    /**
     * 获取一个登录成功的返回消息
     * @param token 成功时返回的token
     * @return
     */
    public static LoginResult CreateSuccessResult(String token){
        return new LoginResult(1,token);
    }
}
