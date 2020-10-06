package com.zhoushiya.shop.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/6 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键
     */
    private long id;

    /**
     * 帐号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 密码
     */
    private String password;
}
