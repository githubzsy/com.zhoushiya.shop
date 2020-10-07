package com.zhoushiya.shop.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/7 15:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfo {
    private String account;
    private String password;
}
