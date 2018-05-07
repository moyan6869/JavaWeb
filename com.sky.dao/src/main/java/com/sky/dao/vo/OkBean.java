package com.sky.dao.vo;

import java.io.Serializable;

/**
 *
 */
public class OkBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String phone;
    private String password;
    private Integer memberType;
    private String headImage;
    private String nickName;
    private String userName;
    private String identityCard;
    private String referrerMemberPhone;
    private String shopDay;
    private String proxyMemberPhone;
    private String createDate;
    private String joinDate;
    private String memberNo;
    private Long inviteCode;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Long getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Long inviteCode) {
        this.inviteCode = inviteCode;
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

    public String getProxyMemberPhone() {
        return proxyMemberPhone;
    }

    public void setProxyMemberPhone(String proxyMemberPhone) {
        this.proxyMemberPhone = proxyMemberPhone;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
}
