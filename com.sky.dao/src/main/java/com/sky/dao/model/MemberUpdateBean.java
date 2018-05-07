package com.sky.dao.model;

import java.io.Serializable;

/**
 * 数据二次同步模型
 * Created by TheBestEternal on 2017/9/15 0015.
 */
public class MemberUpdateBean implements Serializable{

    private static final long serialVersionUID = 4654109563309814543L;

    //系统对接唯一主键识别标示
    private String memberId;
    //会员修改数据类型 null为错误数据
    private Integer type=null;

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
    //购物币  级别修改时 应赠送的购物币 是多少 单位是分  例如 1元  shopCoin=100
    private Integer shopCoin=0;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getShopCoin() {
        return shopCoin;
    }

    public void setShopCoin(Integer shopCoin) {
        this.shopCoin = shopCoin;
    }

    @Override
    public String toString() {
        return "MemberUpdateBean{" +
                "memberId='" + memberId + '\'' +
                ", type=" + type +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", memberType=" + memberType +
                ", headImage='" + headImage + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", referrerMemberPhone='" + referrerMemberPhone + '\'' +
                ", shopDay='" + shopDay + '\'' +
                ", shopCoin=" + shopCoin +
                '}';
    }
}
