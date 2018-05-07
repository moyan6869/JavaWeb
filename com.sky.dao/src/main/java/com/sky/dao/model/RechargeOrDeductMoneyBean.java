package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 手工扣款或者充值记录表对应bean
 * Created by zhangcp on 2016/4/1.11:40
 */
public class RechargeOrDeductMoneyBean implements Serializable {
    private String id;
    /**
     * 会员id
     */
    private String memberId;
    /**
     * 会员手机号
     */
    private String phone;
    /**
     * 收益类型代码(12 扣款 13 充值)
     */
    private int profitType;
    /**
     * 收益类型文字说明(扣款 充值)
     */
    private String profitTypeName;
    /**
     * 扣款类型
     */
    private int deductMoneyType;
    /**
     * 金额（当扣款时为负数，充值时为正数）
     */
    private long amount;
    /**
     * 收益时间(操作人输入或者系统时间)
     */
    private Date profitTime;
    /**
     * 操作人
     */
    private String userName;
    /**
     * 操作时间
     */
    private Date opTime;

    /**
     *扣款备注
     */
    private String remark;

    public String getProfitTypeName() {
        return profitTypeName;
    }

    public void setProfitTypeName(String profitTypeName) {
        this.profitTypeName = profitTypeName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getDeductMoneyType() {
        return deductMoneyType;
    }

    public void setDeductMoneyType(int deductMoneyType) {
        this.deductMoneyType = deductMoneyType;
    }

    public int getProfitType() {
        return profitType;
    }

    public void setProfitType(int profitType) {
        this.profitType = profitType;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Date getProfitTime() {
        return profitTime;
    }

    public void setProfitTime(Date profitTime) {
        this.profitTime = profitTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
