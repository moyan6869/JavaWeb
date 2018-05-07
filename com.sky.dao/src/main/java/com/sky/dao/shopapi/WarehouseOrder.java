package com.sky.dao.shopapi;

import java.io.Serializable;
import java.util.Date;

public class WarehouseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    private String Id;
    private String memberId;
    private String orderId;
    private String orderMemberId;
    private String orderCode;
    private Integer orderMoney;
    private Integer orderStatus = 0;

    private Date payDate;
    private Date createDate;
    private Date updateDate;
    private Integer deleteFlag = 0;

    private Long count;
    private Long sumMoney;
    private Long activityMoney;
    private String warehouseMemberId;

    public String getWarehouseMemberId() {
        return warehouseMemberId;
    }

    public void setWarehouseMemberId(String warehouseMemberId) {
        this.warehouseMemberId = warehouseMemberId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Long sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Long getActivityMoney() {
        return activityMoney;
    }

    public void setActivityMoney(Long activityMoney) {
        this.activityMoney = activityMoney;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getOrderMemberId() {
        return orderMemberId;
    }

    public void setOrderMemberId(String orderMemberId) {
        this.orderMemberId = orderMemberId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    @Override
    public String toString() {
        return "WarehouseOrder{" +
                "Id='" + Id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderMemberId='" + orderMemberId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", orderMoney=" + orderMoney +
                ", orderStatus=" + orderStatus +
                ", payDate=" + payDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteFlag=" + deleteFlag +
                ", count=" + count +
                ", sumMoney=" + sumMoney +
                ", activityMoney=" + activityMoney +
                '}';
    }

    //    private Date  pushDate;
//    private String pushResult;
//    private String paymentNumber;



    //    private String addressId;
//    private String contact;
//    private String phone;
//    private Integer totalMoney = 0;
//    private Integer payCash = 0;
//    private Integer payType = 0;
}
