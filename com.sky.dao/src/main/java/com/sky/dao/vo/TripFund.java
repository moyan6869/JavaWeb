package com.sky.dao.vo;

/**
 * 旅游基金
 * @author qiujingwang
 * @version 1.0
 * @since 1.0
 */
public class TripFund implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	private long sumMoney;//总金额

	public TripFund(){
	}

	public long getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(long sumMoney) {
		this.sumMoney = sumMoney;
	}
}

