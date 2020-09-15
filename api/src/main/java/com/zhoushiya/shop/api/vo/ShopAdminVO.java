package com.zhoushiya.shop.api.vo;

/**
 * @author zhoushiya
 * @date 2020/8/30 15:12
 */
public class ShopAdminVO extends BaseVO {
    public ShopAdminVO(){

    }

    public ShopAdminVO(String account, boolean isValid) {
        this.account = account;
        this.isValid = isValid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    private String account;

    private boolean isValid;
}
