package com.sky.dao.vo;

import java.io.Serializable;

public class HdInviteVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3436075210099917889L;
	
	private String memberId;
	private int   number;
	private int moneyThree;
	private int moneySix;
	private int moneyNine;
	private String userName;
	private String phone;
	private int status;
	public String getMemberId() {
		return memberId;
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
	public int getMoneyThree() {
		return moneyThree;
	}
	public void setMoneyThree(int moneyThree) {
		this.moneyThree = moneyThree;
	}
	public int getMoneySix() {
		return moneySix;
	}
	public void setMoneySix(int moneySix) {
		this.moneySix = moneySix;
	}
	public int getMoneyNine() {
		return moneyNine;
	}
	public void setMoneyNine(int moneyNine) {
		this.moneyNine = moneyNine;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "HdInviteVo [memberId=" + memberId + ", number=" + number + ", moneyThree=" + moneyThree + ", moneySix="
				+ moneySix + ", moneyNine=" + moneyNine + ", userName=" + userName + ", phone=" + phone + ", status="
				+ status + "]";
	}
	

}
