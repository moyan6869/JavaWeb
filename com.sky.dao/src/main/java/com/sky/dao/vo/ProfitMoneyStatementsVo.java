package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ProfitMoneyStatementsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createDate;

    private String moneyFlow;

    private String inOut;

    private String serialNumbers;

    private String moneyStr;

    private BigInteger money;

    private String relevancePhone;

    private String profitSumMoneyStr;

    private BigInteger profitSumMoney;

    private String freezeSumMoneyStr;

    private BigInteger freezeSumMoney;

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

    public String getRelevancePhone() {
        return relevancePhone;
    }

    public void setRelevancePhone(String relevancePhone) {
        this.relevancePhone = relevancePhone;
    }

    public String getProfitSumMoneyStr() {
        return profitSumMoneyStr;
    }

    public void setProfitSumMoneyStr(String profitSumMoneyStr) {
        this.profitSumMoneyStr = profitSumMoneyStr;
    }

    public BigInteger getProfitSumMoney() {
        return profitSumMoney;
    }

    public void setProfitSumMoney(BigInteger profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public String getFreezeSumMoneyStr() {
        return freezeSumMoneyStr;
    }

    public void setFreezeSumMoneyStr(String freezeSumMoneyStr) {
        this.freezeSumMoneyStr = freezeSumMoneyStr;
    }

    public BigInteger getFreezeSumMoney() {
        return freezeSumMoney;
    }

    public void setFreezeSumMoney(BigInteger freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }
}
