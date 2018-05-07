package com.sky.dao.model;

/**
 * 退货流程（第二步）
 * Created by Administrator on 2015/10/22.
 */
public class APIAddRefundGoods2Bean {
    private String orderId;
    private String refundId;
    private String expressName;
    private String expressCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
}