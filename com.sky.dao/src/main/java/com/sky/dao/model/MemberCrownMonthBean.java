package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberCrownMonthBean
 * @version 1.0
 * @author xiaoheliu
 */ 
public class MemberCrownMonthBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String crownMonthId;
	private String memberId;
	private String referenceMemberId;
	private int month;
	private int crownType;
	private int achivementNum;
	private int silverNum;
	private String silverCrownUp;
	private long monthSumMoney;
	private long monthSumSignMoney;
	private long monthSumShopMoney;
	private int monthMeMoney;
	private long monthMeSignMoney;
	private int monthMeShopMoney;
	private int status;
	private Date createDate;
	private Date updateDate;
	private int deleteFlag;
	public String getCrownMonthId() {
		return crownMonthId;
	}
	public void setCrownMonthId(String crownMonthId) {
		this.crownMonthId = crownMonthId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getCrownType() {
		return crownType;
	}
	public void setCrownType(int crownType) {
		this.crownType = crownType;
	}
	public int getAchivementNum() {
		return achivementNum;
	}
	public void setAchivementNum(int achivementNum) {
		this.achivementNum = achivementNum;
	}
	public int getSilverNum() {
		return silverNum;
	}
	public void setSilverNum(int silverNum) {
		this.silverNum = silverNum;
	}
	public String getSilverCrownUp() {
		return silverCrownUp;
	}
	public void setSilverCrownUp(String silverCrownUp) {
		this.silverCrownUp = silverCrownUp;
	}
	public long getMonthSumMoney() {
		return monthSumMoney;
	}
	public void setMonthSumMoney(long monthSumMoney) {
		this.monthSumMoney = monthSumMoney;
	}
	public long getMonthSumSignMoney() {
		return monthSumSignMoney;
	}
	public void setMonthSumSignMoney(long monthSumSignMoney) {
		this.monthSumSignMoney = monthSumSignMoney;
	}
	public long getMonthSumShopMoney() {
		return monthSumShopMoney;
	}
	public void setMonthSumShopMoney(long monthSumShopMoney) {
		this.monthSumShopMoney = monthSumShopMoney;
	}
	public int getMonthMeMoney() {
		return monthMeMoney;
	}
	public void setMonthMeMoney(int monthMeMoney) {
		this.monthMeMoney = monthMeMoney;
	}
	public long getMonthMeSignMoney() {
		return monthMeSignMoney;
	}
	public void setMonthMeSignMoney(long monthMeSignMoney) {
		this.monthMeSignMoney = monthMeSignMoney;
	}
	public int getMonthMeShopMoney() {
		return monthMeShopMoney;
	}
	public void setMonthMeShopMoney(int monthMeShopMoney) {
		this.monthMeShopMoney = monthMeShopMoney;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getReferenceMemberId() {
		return referenceMemberId;
	}
	public void setReferenceMemberId(String referenceMemberId) {
		this.referenceMemberId = referenceMemberId;
	}
	
}

