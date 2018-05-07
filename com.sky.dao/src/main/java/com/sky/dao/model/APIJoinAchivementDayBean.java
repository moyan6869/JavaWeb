package com.sky.dao.model;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 每日推广业绩
 * @Date: 2016/10/7 19:57
 */
public class APIJoinAchivementDayBean {
    private String joinId;
    private String memberId;
    private Integer memberType = 0;
    private Date day;
    private Integer profitSend = 0;
    private long meAchivement;
    private long leftAchivement;
    private Integer status = 0;
    private Integer small = 0; //1左区，2右区
    private long rightAchivement;
    private int indexNumber;


    private long lastLeftRemainder;
    private long lastRightRemainder;
    private long leftRemainder;
    private long rightRemainder;
    private long leftMoney;
    private long rightMoney;

    public String getJoinId() {
        return joinId;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getProfitSend() {
        return profitSend;
    }

    public void setProfitSend(Integer profitSend) {
        this.profitSend = profitSend;
    }

    public long getMeAchivement() {
        return meAchivement;
    }

    public void setMeAchivement(long meAchivement) {
        this.meAchivement = meAchivement;
    }

    public long getLeftAchivement() {
        return leftAchivement;
    }

    public void setLeftAchivement(long leftAchivement) {
        this.leftAchivement = leftAchivement;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        this.small = small;
    }

    public long getRightAchivement() {
        return rightAchivement;
    }

    public void setRightAchivement(long rightAchivement) {
        this.rightAchivement = rightAchivement;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public long getLastLeftRemainder() {
        return lastLeftRemainder;
    }

    public void setLastLeftRemainder(long lastLeftRemainder) {
        this.lastLeftRemainder = lastLeftRemainder;
    }

    public long getLastRightRemainder() {
        return lastRightRemainder;
    }

    public void setLastRightRemainder(long lastRightRemainder) {
        this.lastRightRemainder = lastRightRemainder;
    }

    public long getLeftRemainder() {
        return leftRemainder;
    }

    public void setLeftRemainder(long leftRemainder) {
        this.leftRemainder = leftRemainder;
    }

    public long getRightRemainder() {
        return rightRemainder;
    }

    public void setRightRemainder(long rightRemainder) {
        this.rightRemainder = rightRemainder;
    }

    public long getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(long leftMoney) {
        this.leftMoney = leftMoney;
    }

    public long getRightMoney() {
        return rightMoney;
    }

    public void setRightMoney(long rightMoney) {
        this.rightMoney = rightMoney;
    }
}
