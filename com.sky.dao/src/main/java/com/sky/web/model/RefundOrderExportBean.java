package com.sky.web.model;

/**
 * Created by 建帆 on 2016/3/16.
 */
public class RefundOrderExportBean {
    //订单号	退款人	会员状态	电话号码	订单产品金额 运费金额	订单支付日期	退单日期（受理时间）	退款时间
    private String orderCode;
    private String refundMember;
    private String memberStatus;
    private String phone;
    private String totalMoney;
    private String freight;
    private String payDate;
    private String refundDate;
    private String refundMoneyDate;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getRefundMember() {
        return refundMember;
    }

    public void setRefundMember(String refundMember) {
        this.refundMember = refundMember;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundMoneyDate() {
        return refundMoneyDate;
    }

    public void setRefundMoneyDate(String refundMoneyDate) {
        this.refundMoneyDate = refundMoneyDate;
    }
}
