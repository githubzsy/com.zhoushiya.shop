package com.zhoushiya.shop.api.vo;

/**
 * 用户展示类
 * @author zhoushiya
 * @date 2020/8/25 22:53
 */
public class ShopUserVO extends BaseVO {

    /**
     * 保留无参构造函数给映射类调用
     */
    public ShopUserVO() {
    }

    public ShopUserVO(String nickName, String account, Long mobile) {
        this.nickName = nickName;
        this.account = account;
        this.mobile = mobile;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    private String nickName;

    private String account;

    private Long mobile;
}
