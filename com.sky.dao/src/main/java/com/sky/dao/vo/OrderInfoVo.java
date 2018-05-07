package com.sky.dao.vo;

/**
 * 封装订单的业绩及收益查询界面的订单信息
 * Created by zhangcp on 2016/4/14.15:33
 */
public class OrderInfoVo {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 下单客户
     */
    private String orderMemberName;
    /**
     * 订单类型
     */
    private int orderType;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderMemberName() {
        return orderMemberName;
    }

    public void setOrderMemberName(String orderMemberName) {
        this.orderMemberName = orderMemberName;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
}
