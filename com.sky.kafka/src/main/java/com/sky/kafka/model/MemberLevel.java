package com.sky.kafka.model;

public class MemberLevel {
	@Override
	public String toString() {
		return "MemberLevel [memberId=" + memberId + ", orderId=" + orderId + "]";
	}
	private String memberId;
	private String orderId;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
