package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Administrator on 2017/3/8 0008.
 */
public class Member implements Serializable,Comparable{
    private int incId;
    private String memberId;
    private String placeMemberId;
    private String leftMemberId;
    private String rightMemberId;
    private String identityCard;
    private int memberType;
    private String userName;
    private String nickName;
    private String headImage;
    private String phone;
    private BigInteger sumMoney;
    private BigInteger otherMoney;
    private boolean show = false;
    private boolean me = false;
    private String crowLevelStr ;

    public String getCrowLevelStr() {
        return crowLevelStr;
    }

    public void setCrowLevelStr(String crowLevelStr) {
        this.crowLevelStr = crowLevelStr;
    }

    public BigInteger getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigInteger otherMoney) {
        this.otherMoney = otherMoney;
    }

    public boolean getMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public BigInteger getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigInteger sumMoney) {
        this.sumMoney = sumMoney;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public int getIncId() {
        return incId;
    }

    public void setIncId(int incId) {
        this.incId = incId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPlaceMemberId() {
        return placeMemberId;
    }

    public void setPlaceMemberId(String placeMemberId) {
        this.placeMemberId = placeMemberId;
    }

    public String getLeftMemberId() {
        return leftMemberId;
    }

    public void setLeftMemberId(String leftMemberId) {
        this.leftMemberId = leftMemberId;
    }

    public String getRightMemberId() {
        return rightMemberId;
    }

    public void setRightMemberId(String rightMemberId) {
        this.rightMemberId = rightMemberId;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Object o) {
        Member m = (Member) o;
        return this.getSumMoney().compareTo(m.getSumMoney());
    }
}
