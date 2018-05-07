package com.sky.dao.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/26.
 */
public class MemberMoneyTotalBean implements Serializable{
	
	private static final long serialVersionUID = 3892487995057402706L;



	private String memberId;
	/**  可提现余额  */
	private long availableMoney;
	private long unfreezeMoney;
	/**提现总金额 */
	private long dealSumMoney;
    /** 总收益  */
    private long paySumMoney;
	private long trsinSumMoney;
	private long trsoutSumMoney;
	private int	indexNumber;
	/** 新版可提现余额**/
	private long useMoney;
	/** 换货币 **/
	private long change_coin;
	/** 复销币 **/
	private long compound_coin;
	/** 补货币 **/
	private long supplyCoin;




	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

    public long getSupplyCoin() {
        return supplyCoin;
    }

    public void setSupplyCoin(long supplyCoin) {
        this.supplyCoin = supplyCoin;
    }

    public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public long getAvailableMoney() {
		return availableMoney;
	}

	public void setAvailableMoney(long availableMoney) {
		this.availableMoney = availableMoney;
	}

	public long getUnfreezeMoney() {
		return unfreezeMoney;
	}

	public void setUnfreezeMoney(long unfreezeMoney) {
		this.unfreezeMoney = unfreezeMoney;
	}

	public long getDealSumMoney() {
		return dealSumMoney;
	}

	public void setDealSumMoney(long dealSumMoney) {
		this.dealSumMoney = dealSumMoney;
	}

	public long getPaySumMoney() {
		return paySumMoney;
	}

	public void setPaySumMoney(long paySumMoney) {
		this.paySumMoney = paySumMoney;
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

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public long getUseMoney() {
		return useMoney;
	}

	public long getChange_coin() {
		return change_coin;
	}

	public void setChange_coin(long change_coin) {
		this.change_coin = change_coin;
	}

	public long getCompound_coin() {
		return compound_coin;
	}

	public void setCompound_coin(long compound_coin) {
		this.compound_coin = compound_coin;
	}

	public void setUseMoney(long useMoney) {
		this.useMoney = useMoney;
	}
}
