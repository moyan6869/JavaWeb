package com.sky.dao.vo;

import java.io.Serializable;


/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class ShortMoneyBean implements Serializable{
    private long totalRetailMoney;
    private long meJoinMoney;
    private long prestoredSumMoney;

    private int memberLevel;
    private String memberCurrentLevel;
    private long shortMoney;

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemberCurrentLevel() {
        return memberCurrentLevel;
    }

    public void setMemberCurrentLevel(String memberCurrentLevel) {
        this.memberCurrentLevel = memberCurrentLevel;
    }

    public long getShortMoney() {
        return shortMoney;
    }

    public void setShortMoney(long shortMoney) {
        this.shortMoney = shortMoney;
    }

    public long getTotalRetailMoney() {
        return totalRetailMoney;
    }

    public void setTotalRetailMoney(long totalRetailMoney) {
        this.totalRetailMoney = totalRetailMoney;
    }

    public long getMeJoinMoney() {
        return meJoinMoney;
    }

    public void setMeJoinMoney(long meJoinMoney) {
        this.meJoinMoney = meJoinMoney;
    }

    public long getPrestoredSumMoney() {
        return prestoredSumMoney;
    }

    public void setPrestoredSumMoney(long prestoredSumMoney) {
        this.prestoredSumMoney = prestoredSumMoney;
    }
}
