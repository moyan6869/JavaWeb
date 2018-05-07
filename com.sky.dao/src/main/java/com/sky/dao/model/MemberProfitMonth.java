package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MemberProfitMonth implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2194353809445185677L;
	
	private String profitMonthId;
	private String memberId;
	private long  	monthProfitSumMoney;
	private long monthProfitSignMoney;
	private long monthProfitShopMoney;
	private int month;
	private Date createDate;
	private Date updateDate;
	private int deleteFlag;
	@Override
	public String toString() {
		return "MemberProfitMonth [profitMonthId=" + profitMonthId + ", memberId=" + memberId + ", monthProfitSumMoney="
				+ monthProfitSumMoney + ", monthProfitSignMoney=" + monthProfitSignMoney + ", monthprofitShopMoney="
				+ monthProfitShopMoney + ", month=" + month + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", deleteFlag=" + deleteFlag + "]";
	}
	
	public long getMonthProfitShopMoney() {
		return monthProfitShopMoney;
	}

	public void setMonthProfitShopMoney(long monthProfitShopMoney) {
		this.monthProfitShopMoney = monthProfitShopMoney;
	}

	public String getProfitMonthId() {
		return profitMonthId;
	}
	public void setProfitMonthId(String profitMonthId) {
		this.profitMonthId = profitMonthId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public long getMonthProfitSumMoney() {
		return monthProfitSumMoney;
	}
	public void setMonthProfitSumMoney(long monthProfitSumMoney) {
		this.monthProfitSumMoney = monthProfitSumMoney;
	}
	public long getMonthProfitSignMoney() {
		return monthProfitSignMoney;
	}
	public void setMonthProfitSignMoney(long monthProfitSignMoney) {
		this.monthProfitSignMoney = monthProfitSignMoney;
	}
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
