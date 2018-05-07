package com.sky.dao.model;

/**
 * Created by Administrator on 2015/11/30.
 */
public class APIUserMonthAchivementBean {

    /**
     * 月份
     */
    private Integer month;

    /**
     * 月业绩总金额
     */
    private long monthSumMoney;

    /**
     * 月消费总金额
     */
    private long monthMeMoney;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public long getMonthSumMoney() {
        return monthSumMoney;
    }

    public void setMonthSumMoney(long monthSumMoney) {
        this.monthSumMoney = monthSumMoney;
    }

    public long getMonthMeMoney() {
        return monthMeMoney;
    }

    public void setMonthMeMoney(long monthMeMoney) {
        this.monthMeMoney = monthMeMoney;
    }
}
