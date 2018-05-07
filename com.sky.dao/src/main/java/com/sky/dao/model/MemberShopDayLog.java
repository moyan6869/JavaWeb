package com.sky.dao.model;

import java.math.BigInteger;
import java.util.Date;

public class MemberShopDayLog {
	private String orderId;
	private BigInteger sortIndex;
	private String memberId;
	private int type;
	private int orderMemberType;
	private int orderShopType;
	private int addUpType;
	private int orderMoney;
	private int number;
	private Date payDate;
	private Date shopDay;
	private int status;
	private Date createDate;
	@Override
	public String toString() {
		return "MemberShopDayLog [orderId=" + orderId + ", sortIndex=" + sortIndex + ", memberId=" + memberId
				+ ", type=" + type + ", orderMemberType=" + orderMemberType + ", orderShopType=" + orderShopType
				+ ", addUpType=" + addUpType + ", orderMoney=" + orderMoney + ", number=" + number + ", payDate="
				+ payDate + ", shopDay=" + shopDay + ", status=" + status + ", createDate=" + createDate + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigInteger getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(BigInteger sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrderMemberType() {
		return orderMemberType;
	}
	public void setOrderMemberType(int orderMemberType) {
		this.orderMemberType = orderMemberType;
	}
	public int getOrderShopType() {
		return orderShopType;
	}
	public void setOrderShopType(int orderShopType) {
		this.orderShopType = orderShopType;
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public Date getShopDay() {
		return shopDay;
	}
	public void setShopDay(Date shopDay) {
		this.shopDay = shopDay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getAddUpType() {
		return addUpType;
	}
	public void setAddUpType(int addUpType) {
		this.addUpType = addUpType;
	}
}
