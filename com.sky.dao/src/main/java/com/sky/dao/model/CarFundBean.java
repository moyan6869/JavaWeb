package com.sky.dao.model;

public class CarFundBean {
	private String memberId;
	private long sumMoney;
	
	@Override
	public String toString() {
		return "TripFundBean [memberId=" + memberId + ", sumMoney=" + sumMoney + "]";
	}
	public long getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(long sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}
