package com.sky.dao.vo;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/1
 * Description:代报单订单余额支付类
 */
public class DoingPayProxyOrderVo extends DoingPayOrderVo {
    private String orderMemberId;//订单的memberId

    public String getOrderMemberId() {
        return orderMemberId;
    }

    public void setOrderMemberId(String orderMemberId) {
        this.orderMemberId = orderMemberId;
    }

    @Override
    public String toString() {
        return "DoingPayProxyOrderVo{" +
                "orderMemberId='" + orderMemberId + '\'' + super.toString() +
                '}' ;
    }
}
