package com.sky.dao.vo;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/10/20 14:47
 */
public class APIMemberCurrent2Bean {
    private String memberId;
    private Date shopDay;
    private long meJoinMoney;
    private long totalJoinMoney;
    private long meRetailMoney;
    private long totalRetailMoney;
    private Date upDate;
    private long prestoredSumMoney;
    private long meSaleMoney;
    private long totalSaleMoney;

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

    public long getPrestoredSumMoney() {
        return prestoredSumMoney;
    }

    public void setPrestoredSumMoney(long prestoredSumMoney) {
        this.prestoredSumMoney = prestoredSumMoney;
    }

    public long getMeSaleMoney() {
        return meSaleMoney;
    }

    public void setMeSaleMoney(long meSaleMoney) {
        this.meSaleMoney = meSaleMoney;
    }

    public long getTotalSaleMoney() {
        return totalSaleMoney;
    }

    public void setTotalSaleMoney(long totalSaleMoney) {
        this.totalSaleMoney = totalSaleMoney;
    }
}
