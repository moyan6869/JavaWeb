package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class AvailableMoneyStatementsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createDate;

    private String moneyFlow;

    private String inOut;

    private String serialNumbers;

    private String moneyStr;

    private BigInteger money;

    private String status;

    private String relevancePhone;

    private String availableMoneyStr;

    private BigInteger availableMoney;

    private String remark;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMoneyFlow() {
        return moneyFlow;
    }

    public void setMoneyFlow(String moneyFlow) {
        this.moneyFlow = moneyFlow;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getSerialNumbers() {
        return serialNumbers;
    }

    public void setSerialNumbers(String serialNumbers) {
        this.serialNumbers = serialNumbers;
    }

    public String getMoneyStr() {
        return moneyStr;
    }

    public void setMoneyStr(String moneyStr) {
        this.moneyStr = moneyStr;
    }

    public BigInteger getMoney() {
        return money;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelevancePhone() {
        return relevancePhone;
    }

    public void setRelevancePhone(String relevancePhone) {
        this.relevancePhone = relevancePhone;
    }

    public String getAvailableMoneyStr() {
        return availableMoneyStr;
    }

    public void setAvailableMoneyStr(String availableMoneyStr) {
        this.availableMoneyStr = availableMoneyStr;
    }

    public BigInteger getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigInteger availableMoney) {
        this.availableMoney = availableMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
