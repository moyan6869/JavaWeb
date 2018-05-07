package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MemberGoldSupportBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5473106182937367442L;
	private String hdLogId;
	private String memberId;
	private int memberType;
	private int month;
	private String referrerMemberId;
	private String crownUp;
	private long achivementMoney;
	private long achivementReduceMoney;
	private int discount;
	private int money;
	private int status;
	private Date createDate;
	private int deleteFlag;
	private Date updateDate;
	@Override
	public String toString() {
		return "MemberGoldSupportBean [hdLogId=" + hdLogId + ", memberId=" + memberId + ", memberType=" + memberType
				+ ", month=" + month + ", referrerMemberId=" + referrerMemberId + ", crownUp=" + crownUp
				+ ", achivementMoney=" + achivementMoney + ", achivementReduceMoney=" + achivementReduceMoney
				+ ", discount=" + discount + ", money=" + money + ", status=" + status + ", createDate=" + createDate
				+ ", deleteFlag=" + deleteFlag + ", updateDate=" + updateDate + "]";
	}
	public String getHdLogId() {
		return hdLogId;
	}
	public void setHdLogId(String hdLogId) {
		this.hdLogId = hdLogId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getReferrerMemberId() {
		return referrerMemberId;
	}
	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}
	public String getCrownUp() {
		return crownUp;
	}
	public void setCrownUp(String crownUp) {
		this.crownUp = crownUp;
	}
	public long getAchivementMoney() {
		return achivementMoney;
	}
	public void setAchivementMoney(long achivementMoney) {
		this.achivementMoney = achivementMoney;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
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
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public long getAchivementReduceMoney() {
		return achivementReduceMoney;
	}
	public void setAchivementReduceMoney(long achivementReduceMoney) {
		this.achivementReduceMoney = achivementReduceMoney;
	}
	
}
