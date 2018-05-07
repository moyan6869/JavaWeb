package com.sky.dao.log;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 交易日志
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeName")
public class TradeLogBean extends BaseLogBean {

    private static final long serialVersionUID = 1L;

    public TradeLogBean() {
        super();
    }

    private Integer tradeType;

    private String tradeId;

    private String memberId;

    private String orderId;

    private String orderCode;

    public Integer payMoney;

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
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

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    @Override
    public String toString() {
        return "TradeLogBean{" +
                "logId=" + super.getLogId() +
                ", logData='" + super.getLogData() + '\'' +
                ", tradeType='" + this.getTradeType() + '\'' +
                ", tradeId='" + this.getTradeId() + '\'' +
                ", memberId='" + this.getMemberId() + '\'' +
                ", orderId='" + this.getOrderId() + '\'' +
                ", orderCode='" + this.getOrderCode() + '\'' +
                ", payMoney='" + this.getPayMoney() + '\'' +
                ", createDate=" + super.getCreateDate() +
                '}';
    }
}