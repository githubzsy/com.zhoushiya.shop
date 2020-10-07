package com.zhoushiya.shop.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/7 17:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopUser {
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
}
