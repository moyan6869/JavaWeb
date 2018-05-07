package com.sky.dao.vo;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * 用于导出所有会员月度收益
 * Created by zhangcp on 2016/4/25.17:38
 */
public class MemberProfitMonthBean implements Serializable {
    private static DecimalFormat DF = new DecimalFormat("#0.00#");
    /**
     * 运营系统名称
     */
    private String systemName;
    /**
     * 运营id
     */
    private Integer osId;
    /**
     * 会员id
     */
    private String memberId;
    /**
     * 会员姓名
     */
    private String userName;
    /**
     * 会员手机号
     */
    private String phone;
    /**
     * 收益月度
     */
    private Integer month;
    /**
     * 会员月度总收益
     */
    private long monthProfitSumMoney;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getMonthProfitSumMoney() {
        return monthProfitSumMoney;
    }
    public String getMonthProfitSumMoneyStr() {

        return DF.format(monthProfitSumMoney*0.01);
    }

    public void setMonthProfitSumMoney(long monthProfitSumMoney) {
        this.monthProfitSumMoney = monthProfitSumMoney;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
