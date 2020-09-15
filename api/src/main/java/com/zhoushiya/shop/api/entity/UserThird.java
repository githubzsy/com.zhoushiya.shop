package com.zhoushiya.shop.api.entity;

public class UserThird {
    private Integer id;

    private Integer userId;

    private Integer thirdPartyId;

    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(Integer thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}