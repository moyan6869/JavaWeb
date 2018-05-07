package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 月销售业绩表
 * @Date: 2016/9/29 15:02
 */
public class APISaleAchivementMonthBean {
    private String memberId;
    private int month;
    private long sumMoney;
    @JsonIgnore
    private long meMoney;
    private Date createDate;
    private Integer indexNumber = 0;

    public long getMeMoney() {
        return meMoney;
    }

    public void setMeMoney(long meMoney) {
        this.meMoney = meMoney;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(long sumMoney) {
        this.sumMoney = sumMoney;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }
}
