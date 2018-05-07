package com.sky.dao.vo;

import com.sky.dao.enums.GemType;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: api代报单用户详情
 * @Date: 2016/10/6 20:05
 */
public class APIProxyMemberDetailBean {
    private String memberId;
    private String headImage;
    private String phone;
    private String nickName;
    private String userName;
    private String identityCard;
    private Integer memberType=0;
    private String memberTypeStr;
    private Date createDate;
    private Long inviteCode;

    private String referrerMemberName;
    private String referrerMemberNickName;
    private String referrerMemberPhone;
    //private String proxyMemberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeStr() {
        return GemType.getGemTypeName(memberType);
    }

    public void setMemberTypeStr(String memberTypeStr) {
        this.memberTypeStr = memberTypeStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Long getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Long inviteCode) {
        this.inviteCode = inviteCode;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReferrerMemberName() {
        return referrerMemberName;
    }

    public void setReferrerMemberName(String referrerMemberName) {
        this.referrerMemberName = referrerMemberName;
    }

    public String getReferrerMemberNickName() {
        return referrerMemberNickName;
    }

    public void setReferrerMemberNickName(String referrerMemberNickName) {
        this.referrerMemberNickName = referrerMemberNickName;
    }

    public String getReferrerMemberPhone() {
        return referrerMemberPhone;
    }

    public void setReferrerMemberPhone(String referrerMemberPhone) {
        this.referrerMemberPhone = referrerMemberPhone;
    }
}
