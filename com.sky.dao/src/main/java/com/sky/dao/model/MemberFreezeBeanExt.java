package com.sky.dao.model;

/**
 * Created by 建帆 on 2015/12/17.
 */
public class MemberFreezeBeanExt extends MemberFreezeBean {


    private String orderCode;

    private String orderMemberName;

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
    public boolean equals(Object obj){ return super.equals(obj);}
}
