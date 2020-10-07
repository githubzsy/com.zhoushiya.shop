package com.zhoushiya.shop.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResult {
    private long id;
    private String account;
    private String token;
}
