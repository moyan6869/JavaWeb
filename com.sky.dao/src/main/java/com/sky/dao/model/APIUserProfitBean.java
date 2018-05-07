package com.sky.dao.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/26.
 */
public class APIUserProfitBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3167983375191469069L;
    /**
     * 总收益
     */
    private long profitSumMoney;
    /**
     * 可使用奖金币
     */
    private long availableMoney;

    //每月当前可使用的奖金币
    private long availableMoneyMonth;

    public long getReadyMoney() {
        return readyMoney;
    }

    public void setReadyMoney(long readyMoney) {
        this.readyMoney = readyMoney;
    }

    public long getProfitDayMoney() {
        return profitDayMoney;
    }

    public void setProfitDayMoney(long profitDayMoney) {
        this.profitDayMoney = profitDayMoney;
    }

    public long getProfitMonthMoney() {
        return profitMonthMoney;
    }

    public void setProfitMonthMoney(long profitMonthMoney) {
        this.profitMonthMoney = profitMonthMoney;
    }

    /**
     * 前一日的日结总收益

     */
    private long profitDayMoney;
    /**
     * 前一月的月结总收益
     */
    private long profitMonthMoney;
    /**
     * 可提现余额
     */
    private long readyMoney;

    /**
     * 货款
     */
    private long prestored;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getShoppingcurrency() {
        return shoppingcurrency;
    }

    public void setShoppingcurrency(long shoppingcurrency) {
        this.shoppingcurrency = shoppingcurrency;
    }

    /**
     * 购物币
     */
    private long shoppingcurrency;


    /**
     * 复消币
     */

    private long compoundCoin;

    @Override
    public String toString() {
        return "APIUserProfitBean{" +
                "profitSumMoney=" + profitSumMoney +
                ", availableMoney=" + availableMoney +
                ", prestored=" + prestored +
                ", shoppingcurrency=" + shoppingcurrency +
                ", compoundCoin=" + compoundCoin +
                ", changeCoin=" + changeCoin +
                ", freezeSumMoney=" + freezeSumMoney +
                ", dealSumMoney=" + dealSumMoney +
                ", paySumMoney=" + paySumMoney +
                ", monthApplyMoney=" + monthApplyMoney +
                ", trsinSumMoney=" + trsinSumMoney +
                ", trsoutSumMoney=" + trsoutSumMoney +
                '}';
    }

    /**
     * 换货币
     */
    private long changeCoin;

    /**
     * 冻结金额
     */
    private long freezeSumMoney;

    /**
     * 提现总金额
     */
    private long dealSumMoney;

    /**
     * 支付密码
     */
    private long paySumMoney;

    /**
     * 本月累计提现金额
     */
    private long monthApplyMoney;

    /**
     * 转帐（转入）累计金额
     */
    private long trsinSumMoney;

    /**
     * 转帐（转出）累计金额
     */
    private long trsoutSumMoney;

    public long getCompoundCoin() {
        return compoundCoin;
    }

    public void setCompoundCoin(long compoundCoin) {
        this.compoundCoin = compoundCoin;
    }

    public long getChangeCoin() {
        return changeCoin;
    }

    public void setChangeCoin(long changeCoin) {
        this.changeCoin = changeCoin;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getProfitSumMoney() {
        return profitSumMoney;
    }

    public void setProfitSumMoney(long profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public long getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public long getPrestored() {
        return prestored;
    }

    public void setPrestored(long prestored) {
        this.prestored = prestored;
    }

    public long getFreezeSumMoney() {
        return freezeSumMoney;
    }

    public void setFreezeSumMoney(long freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }

    public long getDealSumMoney() {
        return dealSumMoney;
    }

    public void setDealSumMoney(long dealSumMoney) {
        this.dealSumMoney = dealSumMoney;
    }

    public long getMonthApplyMoney() {
        return monthApplyMoney;
    }

    public void setMonthApplyMoney(long monthApplyMoney) {
        this.monthApplyMoney = monthApplyMoney;
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

    public long getPaySumMoney() {
        return paySumMoney;
    }

    public void setPaySumMoney(long paySumMoney) {
        this.paySumMoney = paySumMoney;
    }

    public long getAvailableMoneyMonth() {
        return availableMoneyMonth;
    }

    public void setAvailableMoneyMonth(long availableMoneyMonth) {
        this.availableMoneyMonth = availableMoneyMonth;
    }
}
