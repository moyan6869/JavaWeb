package com.sky.dao.vo;

import com.sky.dao.model.APIOrderBean;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * MemberDealBean
 *
 * @author dao
 * @version 1.0
 */
public class MemberPayBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore()
    private String payId;
    @JsonIgnore()
    private BigInteger sortIndex;
    private String payCode;
    @JsonIgnore()
    private String memberId;
    private int type;
    @JsonIgnore()
    private String orderId;
    @JsonIgnore()
    private String orderMemberId;
    private int orderSumMoney;
    private int payMoney;
    @JsonIgnore()
    private long paySumMoney;
    @JsonIgnore()
    private long availableMoney;
    @JsonIgnore()
    private int status;
    private Date createTime;

    private APIOrderBean order;

    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 下单客户
     */
    private String OrderMemberName;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderMemberName() {
        return OrderMemberName;
    }

    public void setOrderMemberName(String orderMemberName) {
        OrderMemberName = orderMemberName;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public BigInteger getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(BigInteger sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public int getOrderSumMoney() {
        return orderSumMoney;
    }

    public void setOrderSumMoney(int orderSumMoney) {
        this.orderSumMoney = orderSumMoney;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public long getPaySumMoney() {
        return paySumMoney;
    }

    public void setPaySumMoney(long paySumMoney) {
        this.paySumMoney = paySumMoney;
    }

    public long getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public APIOrderBean getOrder() {
        return order;
    }

    public void setOrder(APIOrderBean order) {
        this.order = order;
    }
}

