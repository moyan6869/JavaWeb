package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JacksonInject;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 销售业绩日志表
 * @Date: 2016/10/10 11:02
 */
public class APISaleAchivementLogBean {

    @JsonIgnore
    public String memberId;
    public Integer type = 0;
    public String typeStr;
    @JsonIgnore
    public String sortIndex;
    @JsonIgnore
    public String nextMemberId;
    @JsonIgnore
    public String orderId;
    @JsonIgnore
    public String orderMemberId;
    public String orderCode;
    public long orderMoney;
    @JsonIgnore
    public String orderMonth;
    public long sumAchivement;
    @JsonIgnore
    public int level;
    public Date payDate;
    public Date createDate;

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public long getSumAchivement() {
        return sumAchivement;
    }

    public void setSumAchivement(long sumAchivement) {
        this.sumAchivement = sumAchivement;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
