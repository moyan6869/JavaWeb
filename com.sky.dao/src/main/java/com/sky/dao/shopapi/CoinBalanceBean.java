package com.sky.dao.shopapi;

import java.io.Serializable;
import java.util.Date;

public class CoinBalanceBean implements Serializable{

    private String balanceId;
    private int sortIndx;
    private String balanceCode;
    private String memberId;
    private Integer coinType;
    private Integer type;
    private Integer flowType;
    private Integer flowCoin;
    private String orderId;
    private String orderMemberId;
    private String orderCode;
    private String inMemberId;
    private String outMemberId;
    private Long foodCoin;
    private Long supplyCoin;
    private String operation;

    private Date createDate;
    private Date updateDate;
    private int deleteFlag;
    private String typeStr;

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public int getSortIndx() {
        return sortIndx;
    }

    public void setSortIndx(int sortIndx) {
        this.sortIndx = sortIndx;
    }

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getCoinType() {
        return coinType;
    }

    public void setCoinType(Integer coinType) {
        this.coinType = coinType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlowType() {
        return flowType;
    }

    public void setFlowType(Integer flowType) {
        this.flowType = flowType;
    }

    public Integer getFlowCoin() {
        return flowCoin;
    }

    public void setFlowCoin(Integer flowCoin) {
        this.flowCoin = flowCoin;
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

    public String getInMemberId() {
        return inMemberId;
    }

    public void setInMemberId(String inMemberId) {
        this.inMemberId = inMemberId;
    }

    public String getOutMemberId() {
        return outMemberId;
    }

    public void setOutMemberId(String outMemberId) {
        this.outMemberId = outMemberId;
    }

    public Long getFoodCoin() {
        return foodCoin;
    }

    public void setFoodCoin(Long foodCoin) {
        this.foodCoin = foodCoin;
    }

    public Long getSupplyCoin() {
        return supplyCoin;
    }

    public void setSupplyCoin(Long supplyCoin) {
        this.supplyCoin = supplyCoin;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
