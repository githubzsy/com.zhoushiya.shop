package com.zhoushiya.shop.auth.vo;

import com.zhoushiya.shop.auth.entity.User;
import com.zhoushiya.shop.common.vo.BaseVOWithIdImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户展示类
 * @author zhoushiya
 * @date 2020/8/25 22:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends BaseVOWithIdImpl {
    private String account;
}
