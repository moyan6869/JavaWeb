package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/22
 * Description:转账--请求参数
 */
public class MemberTransferVo implements Serializable{
    /**
     * 收款方手机号
     */
    private String payeePhone;
    /**
     * 转账金额
     */
    private Long transferMoney;
    /**
     * 付款方登录密码
     */
    private String password;
    /**
     * 短信验证码
     */
    private String checkNumber;
    /**
     * 交易摘要
     */
    private String trsMemo;
    /**
     * 来源
     */
    private Integer transferFrom;
    /**
     * 付款方memberId
     */
    private String payerMemberId;

    /**
     * 收款方memberId
     */
    private String payeeMemberId;

    public String getPayeePhone() {
        return payeePhone;
    }

    public void setPayeePhone(String payeePhone) {
        this.payeePhone = payeePhone;
    }

    public Long getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(Long transferMoney) {
        this.transferMoney = transferMoney;
    }

    public String getTrsMemo() {
        return trsMemo;
    }

    public void setTrsMemo(String trsMemo) {
        this.trsMemo = trsMemo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayerMemberId() {
        return payerMemberId;
    }

    public void setPayerMemberId(String payerMemberId) {
        this.payerMemberId = payerMemberId;
    }

    public String getPayeeMemberId() {
        return payeeMemberId;
    }

    public void setPayeeMemberId(String payeeMemberId) {
        this.payeeMemberId = payeeMemberId;
    }

    public Integer getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(Integer transferFrom) {
        this.transferFrom = transferFrom;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
