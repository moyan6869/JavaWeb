package com.sky.web.model;

import java.util.Date;

/**
 * Created by 建帆 on 2015/12/9.
 */
public class RefundGoods {
    private String refundId;
    private String refundCode;
    private Integer refundType = 0;
    private Integer refundStatus = 0;
    private String refundResult;
    private String memberId;
    private String orderId;
    private String isRefundMoney;
    private String orderCode;
    private String refundGoodsReason;
    private Integer isAllowRefundGoods = 0;
    private Integer isRefundGoods = 0;
    private Date refundGoodsDate;
    private Integer refundGoodsExpressId = 0;
    private String refundGoodsExpressName;
    private String refundGoodsExpressCode;
    private String refundGoodsExpressCode2;
    private Integer isReceivedRefundGoods = 0;
    private String isReceivedRefundGoodsDate;
    private String isReceivedRefundGoodsRemark;

    public String getIsRefundMoney() {
		return isRefundMoney;
	}

	public void setIsRefundMoney(String isRefundMoney) {
		this.isRefundMoney = isRefundMoney;
	}

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

    public String getRefundGoodsReason() {
        return refundGoodsReason;
    }

    public void setRefundGoodsReason(String refundGoodReason) {
        this.refundGoodsReason = refundGoodReason;
    }

    public Integer getIsAllowRefundGoods() {
        return isAllowRefundGoods;
    }

    public void setIsAllowRefundGoods(Integer isAllowRefundGoods) {
        this.isAllowRefundGoods = isAllowRefundGoods;
    }

    public Integer getIsRefundGoods() {
        return isRefundGoods;
    }

    public void setIsRefundGoods(Integer isRefundGoods) {
        this.isRefundGoods = isRefundGoods;
    }

    public Date getRefundGoodsDate() {
        return refundGoodsDate;
    }

    public void setRefundGoodsDate(Date refundGoodsDate) {
        this.refundGoodsDate = refundGoodsDate;
    }

    public Integer getRefundGoodsExpressId() {
        return refundGoodsExpressId;
    }

    public void setRefundGoodsExpressId(Integer refundGoodsExpressId) {
        this.refundGoodsExpressId = refundGoodsExpressId;
    }

    public String getRefundGoodsExpressName() {
        return refundGoodsExpressName;
    }

    public void setRefundGoodsExpressName(String refundGoodsExpressName) {
        this.refundGoodsExpressName = refundGoodsExpressName;
    }

    public String getRefundGoodsExpressCode() {
        return refundGoodsExpressCode;
    }

    public void setRefundGoodsExpressCode(String refundGoodsExpressCode) {
        this.refundGoodsExpressCode = refundGoodsExpressCode;
    }

    public String getRefundGoodsExpressCode2() {
        return refundGoodsExpressCode2;
    }

    public void setRefundGoodsExpressCode2(String refundGoodsExpressCode2) {
        this.refundGoodsExpressCode2 = refundGoodsExpressCode2;
    }

    public Integer getIsReceivedRefundGoods() {
        return isReceivedRefundGoods;
    }

    public void setIsReceivedRefundGoods(Integer isReceivedRefundGoods) {
        this.isReceivedRefundGoods = isReceivedRefundGoods;
    }

    public String getIsReceivedRefundGoodsDate() {
        return isReceivedRefundGoodsDate;
    }

    public void setIsReceivedRefundGoodsDate(String isReceivedRefundGoodsDate) {
        this.isReceivedRefundGoodsDate = isReceivedRefundGoodsDate;
    }

    public String getIsReceivedRefundGoodsRemark() {
        return isReceivedRefundGoodsRemark;
    }

    public void setIsReceivedRefundGoodsRemark(String isReceivedRefundGoodsRemark) {
        this.isReceivedRefundGoodsRemark = isReceivedRefundGoodsRemark;
    }

}
