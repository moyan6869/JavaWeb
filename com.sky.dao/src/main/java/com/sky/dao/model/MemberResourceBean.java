package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统对接 会员数据 模型
 * Created by TheBestEternal on 2017/09/15.
 */
public class MemberResourceBean implements Serializable {

    private static final long serialVersionUID = 5454155825319835342L;

    //系统对接唯一主键识别标示  数据写入时 直接 给一个32UUID到云猫系统  ***重要***
    private String memberId;
    //会员手机号 (系统登录帐号,唯一识别值, 金三角帐号为  10086a ,10086b  10086c )
    private String phone;
    //密码  md5 加密原则 如二次加密过 无法解密 直接写null
    private String password=null;
    //会员级别 0 非会员 1金卡 2钻卡 3体验中心
    private Integer memberType=0;
    //会员头像url地址
    private String headImage;
    //会员昵称
    private String nickName;
    //会员姓名
    private String userName;
    //会员身份证号
    private String identityCard;
    //会员推荐 手机号
    private String referrerMemberPhone;
    //会员活跃期
    private String shopDay;
    //会员代保单人手机号 自主注册为 null 就好
    private String proxyMemberPhone=null;
    //会员注册时间 不写的话 默认系统互写时间
    private Date createDate=null;
    //会员加盟时间  不懈的话 默认系统互写时间
    private Date joinDate=null;
    //外系统数据库唯一识别标示   主键 (外系统的数据库会员主键,备用 可为null)
    private String memberNo=null;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "MemberResourceBean{" +
                "memberId='" + memberId + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", memberType=" + memberType +
                ", headImage='" + headImage + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", referrerMemberPhone='" + referrerMemberPhone + '\'' +
                ", shopDay='" + shopDay + '\'' +
                ", proxyMemberPhone='" + proxyMemberPhone + '\'' +
                ", createDate=" + createDate +
                ", joinDate=" + joinDate +
                ", memberNo='" + memberNo + '\'' +
                '}';
    }
}
