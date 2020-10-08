package com.zhoushiya.shop.auth.entity;

import com.zhoushiya.shop.common.entity.BaseEntity;
import com.zhoushiya.shop.common.entity.BaseEntityWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntityWithId {
    private String account;
    private String password;
}

