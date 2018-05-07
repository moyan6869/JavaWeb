package com.sky.web.model;

import java.util.Date;

/**
 * Created by 建帆 on 2016/4/6.
 */
public class ActivityPrizeModel {

    private String prizeId;
    private String memberId;
    private String activityItemId;
    private Integer isQualify;
    private Integer isGet;
    private String getProductId;
    private Date getDate;
    private String orderId;
    private String orderCode;
    private Date createDate;
    private Date updateDate;
    private Integer deleteFlag;

    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId;
    }

    public Integer getIsQualify() {
        return isQualify;
    }

    public void setIsQualify(Integer isQualify) {
        this.isQualify = isQualify;
    }

    public Integer getIsGet() {
        return isGet;
    }

    public void setIsGet(Integer isGet) {
        this.isGet = isGet;
    }

    public String getGetProductId() {
        return getProductId;
    }

    public void setGetProductId(String getProductId) {
        this.getProductId = getProductId;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
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
}
