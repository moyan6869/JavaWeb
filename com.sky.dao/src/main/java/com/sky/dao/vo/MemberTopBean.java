package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class  MemberTopBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4997544682432254665L;
	
	private String memberId;
	private int number;
	private String userName;
	private String phone;
	private String osId;
	private Date createDate;
	
	
	@Override
	public String toString() {
		return "MemberTopBean [memberId=" + memberId + ", number=" + number + ", userName=" + userName + ", phone="
				+ phone + ", osId=" + osId + ", createDate=" + createDate + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getOsId() {
		return osId;
	}
	public void setOsId(String osId) {
		this.osId = osId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
