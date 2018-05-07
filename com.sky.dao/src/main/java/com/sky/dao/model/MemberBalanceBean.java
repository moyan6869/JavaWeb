package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhangcp on 2016/3/25.11:24
 */
public class MemberBalanceBean implements Serializable {

    /**
     * 支付号
     */
    private String balanceCode;
    /**
     * 流动金额
     */
    private int flowMoney;
    /**
     * 可用余额
     */
    private long availableMoney;
    /**
     * 创建时间
     */
    private Date createTime;

    public int getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(int flowMoney) {
        this.flowMoney = flowMoney;
    }

    public long getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBalanceCode() {
        return balanceCode;
    }

    public void setBalanceCode(String balanceCode) {
        this.balanceCode = balanceCode;
    }
}
