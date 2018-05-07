package com.sky.dao.model;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 零售业绩日志表
 * @Date: 2016/10/10 11:02
 */
public class APIRetailAchivementLogBean {

    public String retailLogId;
    public String memberId;
    public Integer type = 0;
    public String sortIndex;
    public String nextMemberId;
    public String orderId;
    public String orderMemberId;
    public long orderMoney;
    public String orderMonth;
    public Date payDate;
    public Date createDate;

    public String getRetailLogId() {
        return retailLogId;
    }

    public void setRetailLogId(String retailLogId) {
        this.retailLogId = retailLogId;
    }

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

    public String getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(String sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getNextMemberId() {
        return nextMemberId;
    }

    public void setNextMemberId(String nextMemberId) {
        this.nextMemberId = nextMemberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderMemberId() {
        return orderMemberId;
    }

    public void setOrderMemberId(String orderMemberId) {
        this.orderMemberId = orderMemberId;
    }

    public long getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(long orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(String orderMonth) {
        this.orderMonth = orderMonth;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
