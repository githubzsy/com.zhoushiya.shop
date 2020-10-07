package com.zhoushiya.shop.auth.vo;

import com.zhoushiya.shop.common.vo.BaseVO;
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
public class AdminVO extends BaseVO {
    private String account;
}
