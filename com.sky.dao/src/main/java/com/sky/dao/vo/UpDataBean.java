package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by weiyunliang on 2017/10/23.
 */
public class UpDataBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String phone;
    private String newPhone;
    private String password;
    private Integer memberType;
    private String headImage;
    private String nickName;
    private String userName;
    private String identityCard;
    private String referrerMemberPhone;
    private String shopDay;
    private Integer shopCoin;
    private Integer upLevelType;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer type;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getReferrerMemberPhone() {
        return referrerMemberPhone;
    }

    public void setReferrerMemberPhone(String referrerMemberPhone) {
        this.referrerMemberPhone = referrerMemberPhone;
    }

    public String getShopDay() {
        return shopDay;
    }

    public void setShopDay(String shopDay) {
        this.shopDay = shopDay;
    }

    public Integer getShopCoin() {
        return shopCoin;
    }

    public Integer getUpLevelType() {
        return upLevelType;
    }

    public void setUpLevelType(Integer upLevelType) {
        this.upLevelType = upLevelType;
    }

    public void setShopCoin(Integer shopCoin) {
        this.shopCoin = shopCoin;
    }
}
