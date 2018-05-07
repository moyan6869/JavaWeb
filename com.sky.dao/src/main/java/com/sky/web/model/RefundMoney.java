package com.sky.web.model;

import java.util.Date;

/**
 * Created by 建帆 on 2015/12/9.
 */
public class RefundMoney {
    private String refundId;
    private String refundCode;
    private Integer refundType = 0;
    private Integer refundStatus = 0;
    private String refundResult;
    private String memberId;
    private String orderId;
    private String orderCode;
    private Integer totalMoney = 0;
    private Integer freight = 0;
    private String refundMoneyReason;
    private Integer isRefundMoney = 0;
    private Double refundMoney = 0.0;
    private Date refundMoneyDate;
    private String refundMoneyRemark;
    private String proxyMemberId;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundResult() {
        return refundResult;
    }

    public void setRefundResult(String refundResult) {
        this.refundResult = refundResult;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public String getRefundMoneyReason() {
        return refundMoneyReason;
    }

    public void setRefundMoneyReason(String refundMoneyReason) {
        this.refundMoneyReason = refundMoneyReason;
    }


    public Integer getIsRefundMoney() {
        return isRefundMoney;
    }

    public void setIsRefundMoney(Integer isRefundMoney) {
        this.isRefundMoney = isRefundMoney;
    }

    public Double getRefundMoney() {
        return refundMoney*100;
    }

    public void setRefundMoney(Double refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Date getRefundMoneyDate() {
        return refundMoneyDate;
    }

    public void setRefundMoneyDate(Date refundMoneyDate) {
        this.refundMoneyDate = refundMoneyDate;
    }

    public String getRefundMoneyRemark() {
        return refundMoneyRemark;
    }

    public void setRefundMoneyRemark(String refundMoneyRemark) {
        this.refundMoneyRemark = refundMoneyRemark;
    }

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}
}
