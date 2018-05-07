package com.sky.dao.vo;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * 用于导出所有会员总收益
 * Created by zhangcp on 2016/4/19.16:22
 */
public class OsMemberProfitTotalBean implements Serializable {
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
     * 总收益
     */
    private long profitSumMoney;
    /**
     * 可提现余额
     */
    private long availableMoney;

    /**
     * 冻结金额
     */
    private long freezeSumMoney;

    /**
     * 提现总金额
     */
    private long dealSumMoney;

    /**
     * 支付总金额
     */
    private long paySumMoney;
    /**
     * 转入总金额
     */
    private long trsinSumMoney;
    /**
     * 转出总金额
     */
    private long trsoutSumMoney;

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

    public long getProfitSumMoney() {
        return profitSumMoney;
    }
    public String getProfitSumMoneyStr() {

        return DF.format(profitSumMoney*0.01);
    }

    public void setProfitSumMoney(long profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public long getAvailableMoney() {
        return availableMoney;
    }
    public String getAvailableMoneyStr() {

        return DF.format(availableMoney*0.01);
    }

    public void setAvailableMoney(long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public long getFreezeSumMoney() {
        return freezeSumMoney;
    }
    public String getFreezeSumMoneyStr() {
        return DF.format(freezeSumMoney*0.01);
    }

    public void setFreezeSumMoney(long freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }

    public long getDealSumMoney() {
        return dealSumMoney;
    }
    public String getDealSumMoneyStr() {
        return DF.format(dealSumMoney*0.01);
    }

    public void setDealSumMoney(long dealSumMoney) {
        this.dealSumMoney = dealSumMoney;
    }

    public String getPaySumMoneyStr() {
        return DF.format(paySumMoney*0.01);
    }
    public long getPaySumMoney() {
        return paySumMoney;
    }


    public void setPaySumMoney(long paySumMoney) {
        this.paySumMoney = paySumMoney;
    }


    public String getTrsInSumMoneyStr() {
        return DF.format(trsinSumMoney*0.01);
    }



    public String getTrsOutSumMoneyStr() {
        return DF.format(trsoutSumMoney*0.01);
    }

    public long getTrsinSumMoney() {
        return trsinSumMoney;
    }

    public void setTrsinSumMoney(long trsinSumMoney) {
        this.trsinSumMoney = trsinSumMoney;
    }

    public long getTrsoutSumMoney() {
        return trsoutSumMoney;
    }

    public void setTrsoutSumMoney(long trsoutSumMoney) {
        this.trsoutSumMoney = trsoutSumMoney;
    }
}
