package com.sky.dao.model;

/**
 * 退款流程
 * Created by Administrator on 2015/10/22.
 */
public class APIAddRefundMoneyBean {
    private String orderId;
    private String remark;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}