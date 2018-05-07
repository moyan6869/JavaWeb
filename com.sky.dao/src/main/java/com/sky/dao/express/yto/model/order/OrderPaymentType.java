package com.sky.dao.express.yto.model.order;

/**
 * 支付方式枚举：1：已支付；2：货到刷卡；3：货到付现金
 * Created by wangyun on 2015/12/10.
 */
public class OrderPaymentType {
    public final static int paid = 1;
    public final static int creditCard = 2;
    public final static int cashOnDelivery = 3;
}
