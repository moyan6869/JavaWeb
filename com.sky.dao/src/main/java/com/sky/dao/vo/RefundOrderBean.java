package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * RefundOrder00Bean
 *
 * @author Geoffrey
 * @version 1.0
 */
public class RefundOrderBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String refundId;
    private String refundCode;
    private Integer refundType = 0;
    private Integer refundStatus = 0;
    private String refundStatusStr;
    private String refundResult;
    private String memberId;
    private String orderId;
    private String orderCode;
    private Integer totalMoney = 0;
    private Integer freight = 0;
    private String refundMoneyReason;
    private String refundGoodsReason;
    private List<String> refundGoodsImages;
    @JsonIgnore()
    private String refundGoodsImageOne;
    @JsonIgnore()
    private String refundGoodsImageTwo;
    @JsonIgnore()
    private String refundGoodsImageThree;
    @JsonIgnore()
    private String refundGoodsImageFour;
    @JsonIgnore()
    private String refundGoodsImageFive;
    private Integer isAllowRefundGoods = 0;
    private Integer isRefundGoods = 0;
    private Date refundGoodsDate;
    private Integer refundGoodsExpressId = 0;
    private String refundGoodsExpressName;
    private String refundGoodsExpressCode;
    private String refundGoodsExpressCode2;
    private Integer isReceivedRefundGoods = 0;
    private Date isReceivedRefundGoodsDate;
    private String isReceivedRefundGoodsRemark;
    private Integer isRefundMoney = 0;
    private Integer refundMoney = 0;
    private Date refundMoneyDate;
    private String refundMoneyRemark;
    @JsonIgnore()
    private Date createDate;
    @JsonIgnore()
    private Date updateDate;
    @JsonIgnore()
    private Integer deleteFlag = 0;
    private String proxyMemberId;

    private Integer sysUserId;
    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
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

    public String getRefundStatusStr() {
        return refundStatusStr;
    }

    public void setRefundStatusStr(String refundStatusStr) {
        this.refundStatusStr = refundStatusStr;
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

    public String getRefundGoodsReason() {
        return refundGoodsReason;
    }

    public void setRefundGoodsReason(String refundGoodReason) {
        this.refundGoodsReason = refundGoodReason;
    }

    public List<String> getRefundGoodsImages() {
        return refundGoodsImages;
    }

    public void setRefundGoodsImages(List<String> refundGoodsImages) {
        this.refundGoodsImages = refundGoodsImages;
    }

    public String getRefundGoodsImageOne() {
        return refundGoodsImageOne;
    }

    public void setRefundGoodsImageOne(String refundGoodsImageOne) {
        this.refundGoodsImageOne = refundGoodsImageOne;
    }

    public String getRefundGoodsImageTwo() {
        return refundGoodsImageTwo;
    }

    public void setRefundGoodsImageTwo(String refundGoodsImageTwo) {
        this.refundGoodsImageTwo = refundGoodsImageTwo;
    }

    public String getRefundGoodsImageThree() {
        return refundGoodsImageThree;
    }

    public void setRefundGoodsImageThree(String refundGoodsImageThree) {
        this.refundGoodsImageThree = refundGoodsImageThree;
    }

    public String getRefundGoodsImageFour() {
        return refundGoodsImageFour;
    }

    public void setRefundGoodsImageFour(String refundGoodsImageFour) {
        this.refundGoodsImageFour = refundGoodsImageFour;
    }

    public String getRefundGoodsImageFive() {
        return refundGoodsImageFive;
    }

    public void setRefundGoodsImageFive(String refundGoodsImageFive) {
        this.refundGoodsImageFive = refundGoodsImageFive;
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

    public Date getIsReceivedRefundGoodsDate() {
        return isReceivedRefundGoodsDate;
    }

    public void setIsReceivedRefundGoodsDate(Date isReceivedRefundGoodsDate) {
        this.isReceivedRefundGoodsDate = isReceivedRefundGoodsDate;
    }

    public String getIsReceivedRefundGoodsRemark() {
        return isReceivedRefundGoodsRemark;
    }

    public void setIsReceivedRefundGoodsRemark(String isReceivedRefundGoodsRemark) {
        this.isReceivedRefundGoodsRemark = isReceivedRefundGoodsRemark;
    }

    public Integer getIsRefundMoney() {
        return isRefundMoney;
    }

    public void setIsRefundMoney(Integer isRefundMoney) {
        this.isRefundMoney = isRefundMoney;
    }

    public Integer getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Integer refundMoney) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}
}

