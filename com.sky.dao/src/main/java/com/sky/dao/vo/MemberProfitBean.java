package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class MemberProfitBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String profitId;
    private String profitCode;
    private String memberId;
    private Integer type;
    private String orderId;
    private String orderMemberId;
    private Integer orderMoney;
    private Integer profitMoney;
    private Long freezeSumMoney;
    private Long profitSumMoney;
    private Long availableMoney;
    private Integer status;
    private Date createTime;
    private Integer orderMonth;
    private String statusStr;
    private String profitStr;


    public String getProfitId() {
        return profitId;
    }

    public void setProfitId(String profitId) {
        this.profitId = profitId;
    }

    public String getProfitStr() {
        return profitStr;
    }

    public void setProfitStr(String profitStr) {
        this.profitStr = profitStr;
    }

    public String getProfitCode() {
        return profitCode;
    }

    public void setProfitCode(String profitCode) {
        this.profitCode = profitCode;
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

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(Integer profitMoney) {
        this.profitMoney = profitMoney;
    }

    public Long getFreezeSumMoney() {
        return freezeSumMoney;
    }

    public void setFreezeSumMoney(Long freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }

    public Long getProfitSumMoney() {
        return profitSumMoney;
    }

    public void setProfitSumMoney(Long profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public Long getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(Long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderMonth() {
        return orderMonth;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public void setOrderMonth(Integer orderMonth) {
        this.orderMonth = orderMonth;
    }
}
