package com.zhoushiya.shop.auth.entity;

import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.entity.BaseEntityWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntityWithId {
    private String account;
    private String password;
}
