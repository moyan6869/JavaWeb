package com.sky.dao.shopapi;

import java.util.Date;

public class AcheivementVo {

    private Long count;
    private Long sumMoney;
    private Long activityMoney;
    private String  startDate;
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Long sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Long getActivityMoney() {
        return activityMoney;
    }

    public void setActivityMoney(Long activityMoney) {
        this.activityMoney = activityMoney;
    }

    @Override
    public String toString() {
        return "AcheivementVo{" +
                "count=" + count +
                ", sumMoney=" + sumMoney +
                ", activityMoney=" + activityMoney +
                '}';
    }
}
