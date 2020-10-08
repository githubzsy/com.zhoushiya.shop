package com.zhoushiya.shop.auth.vo;

import com.zhoushiya.shop.auth.entity.Admin;
import com.zhoushiya.shop.common.vo.BaseVOWithIdImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO extends BaseVOWithIdImpl {
    private String account;
}
