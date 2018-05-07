package com.sky.dao.model;

import java.io.Serializable;

public class HdInvite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -417265603954438879L;
	private String memberId;
	private int   number;
	private int money_three;
	private int money_six;
	private int money_nine;
	private int status;
	
	@Override
	public String toString() {
		return "HdInvite [memberId=" + memberId + ", number=" + number + ", money_three=" + money_three + ", money_six="
				+ money_six + ", money_nine=" + money_nine + "]";
	}
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
	public int getMoney_three() {
		return money_three;
	}
	public void setMoney_three(int money_three) {
		this.money_three = money_three;
	}
	public int getMoney_six() {
		return money_six;
	}
	public void setMoney_six(int money_six) {
		this.money_six = money_six;
	}
	public int getMoney_nine() {
		return money_nine;
	}
	public void setMoney_nine(int money_nine) {
		this.money_nine = money_nine;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
