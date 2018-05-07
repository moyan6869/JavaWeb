package com.sky.dao.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/9/28 11:13
 */
public class MemberProfitTotalBean {
   private String memberId;
    /**
     * 总收益
     */
    private long profitSumMoney;
    /**
     * 冻结金额
     */
    private long freezeSumMoney;
    private int indexNumber;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getProfitSumMoney() {
        return profitSumMoney;
    }

    public void setProfitSumMoney(long profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public long getFreezeSumMoney() {
        return freezeSumMoney;
    }

    public void setFreezeSumMoney(long freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }
}
