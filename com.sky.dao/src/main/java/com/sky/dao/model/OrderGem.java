package com.sky.dao.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class OrderGem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3078309678630099820L;

	private String orderId;
	private String memberId;
	private BigInteger sortIndex;
	private Date payDate;
	private int orderMoney;
	private int status;
	private int memberType;
	private int shopType;
	private Date shopDay;
	private int number;
	private Date createDate;

	
	@Override
	public String toString() {
		return "OrderGem [orderId=" + orderId + ", memberId=" + memberId + ", sortIndex=" + sortIndex + ", payDate="
				+ payDate + ", orderMoney=" + orderMoney + ", status=" + status + ", memberType=" + memberType
				+ ", shopType=" + shopType + ", shopDay=" + shopDay + ", number=" + number + ", createDate="
				+ createDate + "]";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public BigInteger getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(BigInteger sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public int getShopType() {
		return shopType;
	}

	public void setShopType(int shopType) {
		this.shopType = shopType;
	}

	public Date getShopDay() {
		return shopDay;
	}

	public void setShopDay(Date shopDay) {
		this.shopDay = shopDay;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
