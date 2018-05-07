package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

public class MemberSuperiorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private int memberNum;
	private int monthMoney;
	private int monthMeMoney;
	private Date lastOrderTime;
	private String up1;
	private String up2;
	private String up3;
	private String up4;
	private String up5;
	private String up6;
	private String up7;
	private String up8;
	private String up9;

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getUp1() {
		return up1;
	}
	public void setUp1(String up1) {
		this.up1 = up1;
	}
	public String getUp2() {
		return up2;
	}
	public void setUp2(String up2) {
		this.up2 = up2;
	}
	public String getUp3() {
		return up3;
	}
	public void setUp3(String up3) {
		this.up3 = up3;
	}
	public String getUp4() {
		return up4;
	}
	public void setUp4(String up4) {
		this.up4 = up4;
	}
	public String getUp5() {
		return up5;
	}
	public void setUp5(String up5) {
		this.up5 = up5;
	}
	public String getUp6() {
		return up6;
	}
	public void setUp6(String up6) {
		this.up6 = up6;
	}
	public String getUp7() {
		return up7;
	}
	public void setUp7(String up7) {
		this.up7 = up7;
	}
	public String getUp8() {
		return up8;
	}
	public void setUp8(String up8) {
		this.up8 = up8;
	}
	public String getUp9() {
		return up9;
	}
	public void setUp9(String up9) {
		this.up9 = up9;
	}
	
	@Override
	public String toString() {
		return "MemberSuperiorBean [memberId=" + memberId + ", memberNum=" + memberNum + ", monthMoney=" + monthMoney
				+ ", monthMeMoney=" + monthMeMoney + ", lastOrderTime=" + lastOrderTime + ", up1=" + up1 + ", up2="
				+ up2 + ", up3=" + up3 + ", up4=" + up4 + ", up5=" + up5 + ", up6=" + up6 + ", up7=" + up7 + ", up8="
				+ up8 + ", up9=" + up9 + "]";
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getMonthMoney() {
		return monthMoney;
	}
	public void setMonthMoney(int monthMoney) {
		this.monthMoney = monthMoney;
	}
	public int getMonthMeMoney() {
		return monthMeMoney;
	}
	public void setMonthMeMoney(int monthMeMoney) {
		this.monthMeMoney = monthMeMoney;
	}
	public Date getLastOrderTime() {
		return lastOrderTime;
	}
	public void setLastOrderTime(Date lastOrderTime) {
		this.lastOrderTime = lastOrderTime;
	}
	
	
}
