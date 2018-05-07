package com.sky.dao.vo;

import java.io.Serializable;

/**
 * 收益数据校验结果bean
 * Created by zhangcp on 2016/4/21.14:51
 */
public class OrderAndAchivementValidationMsgBean implements Serializable {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 数据校验结果
     */
    private String msg;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
