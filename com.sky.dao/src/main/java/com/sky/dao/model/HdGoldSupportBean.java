package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class HdGoldSupportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7777124440462333265L;

	private String hdId;
	private int month;
	private long hdSumMoney;
	private int  memberNum;
	private Date updateDate;
	private int status;
	private String memo;
	private Date createDate;
	@Override
	public String toString() {
		return "GoldSupportBean [hdId=" + hdId + ", month=" + month + ", hdSumMoney=" + hdSumMoney + ", memberNum="
				+ memberNum + ", updateDate=" + updateDate + ", status=" + status + ", memo=" + memo + ", createDate="
				+ createDate + "]";
	}
	public String getHdId() {
		return hdId;
	}
	public void setHdId(String hdId) {
		this.hdId = hdId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public long getHdSumMoney() {
		return hdSumMoney;
	}
	public void setHdSumMoney(long hdSumMoney) {
		this.hdSumMoney = hdSumMoney;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
