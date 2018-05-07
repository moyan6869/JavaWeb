package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MemberAchivement implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private Integer type;
	private String referrerMemberId;
	
	private Integer silverCrown;
	private String  silverCrownUp;
	private Integer memberNum;
	private long 	monthMoney;
	private Integer monthMeMoney;
	
	private Integer monthCommission;
	private Integer monthLeader;
	private Integer month;
	private Date CreateDate;
	private Date UpdateDate;
	private Integer DeleteFlag; 
	@Override
	public String toString() {
		return "MemberAchivement [memberId=" + memberId + ", type=" + type + ", referrerMemberId=" + referrerMemberId
				+ ", silverCrown=" + silverCrown + ", silverCrownUp=" + silverCrownUp + ", memberNum=" + memberNum
				+ ", monthMoney=" + monthMoney + ", monthMeMoney=" + monthMeMoney + ", monthCommission="
				+ monthCommission + ", monthLeader=" + monthLeader + ", month=" + month + ", CreateDate=" + CreateDate
				+ ", UpdateDate=" + UpdateDate + ", DeleteFlag=" + DeleteFlag + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getReferrerMemberId() {
		return referrerMemberId;
	}
	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	public Integer getDeleteFlag() {
		return DeleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		DeleteFlag = deleteFlag;
	}
	
	public Integer getSilverCrown() {
		return silverCrown;
	}
	public void setSilverCrown(Integer silverCrown) {
		this.silverCrown = silverCrown;
	}
	public String getSilverCrownUp() {
		return silverCrownUp;
	}
	public void setSilverCrownUp(String silverCrownUp) {
		this.silverCrownUp = silverCrownUp;
	}
	public Integer getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}
	public long getMonthMoney() {
		return monthMoney;
	}
	public void setMonthMoney(long monthMoney) {
		this.monthMoney = monthMoney;
	}
	public Integer getMonthMeMoney() {
		return monthMeMoney;
	}
	public void setMonthMeMoney(Integer monthMeMoney) {
		this.monthMeMoney = monthMeMoney;
	}
	public Integer getMonthCommission() {
		return monthCommission;
	}
	public void setMonthCommission(Integer monthCommission) {
		this.monthCommission = monthCommission;
	}
	
	public Integer getMonthLeader() {
		return monthLeader;
	}
	public void setMonthLeader(Integer monthLeader) {
		this.monthLeader = monthLeader;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	
}
