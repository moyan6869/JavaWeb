package com.sky.dao.vo;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 下单返回订单号对象
 * @Date: 2016/9/28 10:01
 */
public class APIOrderIdBean {
    private String orderId;
    private String orderCode;
    private Integer totalMoney;
    private Integer payCash;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
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

    public Integer getPayCash() {
        return payCash;
    }

    public void setPayCash(Integer payCash) {
        this.payCash = payCash;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }


}
