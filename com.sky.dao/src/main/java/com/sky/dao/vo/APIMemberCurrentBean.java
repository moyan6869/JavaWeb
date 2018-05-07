package com.sky.dao.vo;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/10/20 14:47
 */
public class APIMemberCurrentBean {
    private String memberId;
    private long meJoinMoney;
    private long totalJoinMoney;
    private long meRetailMoney;
    private long totalRetailMoney;
    private Date shopDay;
    private Date upDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getMeJoinMoney() {
        return meJoinMoney;
    }

    public void setMeJoinMoney(long meJoinMoney) {
        this.meJoinMoney = meJoinMoney;
    }

    public long getTotalJoinMoney() {
        return totalJoinMoney;
    }

    public void setTotalJoinMoney(long totalJoinMoney) {
        this.totalJoinMoney = totalJoinMoney;
    }

    public long getMeRetailMoney() {
        return meRetailMoney;
    }

    public void setMeRetailMoney(long meRetailMoney) {
        this.meRetailMoney = meRetailMoney;
    }

    public long getTotalRetailMoney() {
        return totalRetailMoney;
    }

    public void setTotalRetailMoney(long totalRetailMoney) {
        this.totalRetailMoney = totalRetailMoney;
    }

    public Date getShopDay() {
        return shopDay;
    }

    public void setShopDay(Date shopDay) {
        this.shopDay = shopDay;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
