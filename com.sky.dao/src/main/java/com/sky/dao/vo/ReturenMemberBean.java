package com.sky.dao.vo;

import java.io.Serializable;

public class ReturenMemberBean  implements Serializable {
	protected static final long serialVersionUID = 1L;
	private String phone;
	private String memberId;
	private String nickName;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
}
