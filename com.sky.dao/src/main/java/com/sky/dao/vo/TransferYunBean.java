package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class TransferYunBean implements Serializable {
    private String userName;//姓名
    private int inviteCode;//邀请码
    private String phone;//手机号
    private String balanceCode;//流水号


    private String  stat;//类型
    private int flowMoney;//流动金额
    private Date createTime;//时间

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(int inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public int getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(int flowMoney) {
        this.flowMoney = flowMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
