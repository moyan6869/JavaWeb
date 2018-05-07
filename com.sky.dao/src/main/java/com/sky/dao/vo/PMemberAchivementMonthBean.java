package com.sky.dao.vo;

import java.text.DecimalFormat;

/**
 * 用于导出所有会员月度业绩
 * Created by zhangcp on 2016/4/25.17:54
 */
public class PMemberAchivementMonthBean {
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
     * 业绩月度
     */
    private Integer month;
    /**
     * 下级业绩
     */
    private long monthSumMoney;
    /**
     * 自己的业绩
     */
    private Integer monthMeMoney;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public long getMonthSumMoney() {
        return monthSumMoney;
    }
    public String getMonthSumMoneyStr() {

        return DF.format(monthSumMoney*0.01);
    }

    public void setMonthSumMoney(long monthSumMoney) {
        this.monthSumMoney = monthSumMoney;
    }

    public Integer getMonthMeMoney() {
        return monthMeMoney;
    }
    public String getMonthMeMoneyStr() {

        return DF.format(monthMeMoney*0.01);
    }

    public void setMonthMeMoney(Integer monthMeMoney) {
        this.monthMeMoney = monthMeMoney;
    }
}
