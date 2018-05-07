package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/1
 * Description:订单余额支付类
 */
public class  DoingPayOrderVo implements Serializable {
    private static final long serialVersionUID = -4142938540597165058L;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 付款memberId
     */
    private String memberId;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 短信验证码
     */
    private String checkNumber;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public String toString() {
        return "DoingPayOrderVo{" +
                "orderId='" + orderId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}
