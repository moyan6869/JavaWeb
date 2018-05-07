package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class HdBackMoneyVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1856843606867446797L;
	
	private String memberId;
	private int number;
	private int monthStatus4 ;
	private int monthMoney4 ;
	private int monthStatus5 ;
	private int monthMoney5 ;
	private int monthStatus6 ;
	private int monthMoney6 ;
	private Date createDate;
	private int deleteFlag;
	private String UserName;
	private String Phone;
	@Override
	public String toString() {
		return "HdBackMoney [memberId=" + memberId + ", number=" + number + ", monthStatus4=" + monthStatus4
				+ ", monthMoney4=" + monthMoney4 + ", monthStatus5=" + monthStatus5 + ", monthMoney5=" + monthMoney5
				+ ", monthStatus6=" + monthStatus6 + ", monthMoney6=" + monthMoney6 + ", createDate=" + createDate
				+ ", deleteFlag=" + deleteFlag + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMonthStatus4() {
		return monthStatus4;
	}
	public void setMonthStatus4(int monthStatus4) {
		this.monthStatus4 = monthStatus4;
	}
	public int getMonthMoney4() {
		return monthMoney4;
	}
	public void setMonthMoney4(int monthMoney4) {
		this.monthMoney4 = monthMoney4;
	}
	public int getMonthStatus5() {
		return monthStatus5;
	}
	public void setMonthStatus5(int monthStatus5) {
		this.monthStatus5 = monthStatus5;
	}
	public int getMonthMoney5() {
		return monthMoney5;
	}
	public void setMonthMoney5(int monthMoney5) {
		this.monthMoney5 = monthMoney5;
	}
	public int getMonthStatus6() {
		return monthStatus6;
	}
	public void setMonthStatus6(int monthStatus6) {
		this.monthStatus6 = monthStatus6;
	}
	public int getMonthMoney6() {
		return monthMoney6;
	}
	public void setMonthMoney6(int monthMoney6) {
		this.monthMoney6 = monthMoney6;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
