package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MemberAchivementCurrent implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	
	private long totalMoney;
	private long addUpMoney;
	
	private Date shopDayTeam;
	
	private int typeGem;
	private Date	typeGemTime;
	private int typeCrown;
	private Date	typeCrownTime;
	private int typeGold;
	private Date	typeGoldTime;
	
	private int typeKe;
	
	private Date typeKeTime;
	
	private int title;
	private int gemNum;
	private int crownNum;
	private int goldNum;
	private Date	createDate;
	/**
	 * 复购到期日期
	 */
	private Date shopDay;
	
	/*
	 * 会员线状态
	 */
	private int isMemberTeam;
	
	@Override
	public String toString() {
		return "MemberAchivementCurrent [memberId=" + memberId + ", totalMoney=" + totalMoney + ", addUpMoney="
				+ addUpMoney + ", shopDayTeam=" + shopDayTeam + ", typeGem=" + typeGem + ", typeGemTime=" + typeGemTime
				+ ", typeCrown=" + typeCrown + ", typeCrownTime=" + typeCrownTime + ", typeGold=" + typeGold
				+ ", typeGoldTime=" + typeGoldTime + ", title=" + title + ", gemNum=" + gemNum + ", crownNum="
				+ crownNum + ", goldNum=" + goldNum + ", createDate=" + createDate + ", shopDay=" + shopDay
				+ ", isMemberTeam=" + isMemberTeam + "]";
	}

	public long getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(long totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getIsMemberTeam() {
		return isMemberTeam;
	}

	public void setIsMemberTeam(int isMemberTeam) {
		this.isMemberTeam = isMemberTeam;
	}

	public Date getShopDayTeam() {
		return shopDayTeam;
	}
	public void setShopDayTeam(Date shopDayTeam) {
		this.shopDayTeam = shopDayTeam;
	}

	public Date getShopDay() {
		return shopDay;
	}

	public void setShopDay(Date shopDay) {
		this.shopDay = shopDay;
	}

	
	public Date getTypeGemTime() {
		return typeGemTime;
	}
	public void setTypeGemTime(Date typeGemTime) {
		this.typeGemTime = typeGemTime;
	}
	public Date getTypeCrownTime() {
		return typeCrownTime;
	}
	public void setTypeCrownTime(Date typeCrownTime) {
		this.typeCrownTime = typeCrownTime;
	}
	public Date getTypeGoldTime() {
		return typeGoldTime;
	}
	public void setTypeGoldTime(Date typeGoldTime) {
		this.typeGoldTime = typeGoldTime;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getTypeGem() {
		return typeGem;
	}
	public void setTypeGem(int typeGem) {
		this.typeGem = typeGem;
	}
	public int getTypeCrown() {
		return typeCrown;
	}
	public void setTypeCrown(int typeCrown) {
		this.typeCrown = typeCrown;
	}
	public int getTypeGold() {
		return typeGold;
	}
	public void setTypeGold(int typeGold) {
		this.typeGold = typeGold;
	}
	
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getGemNum() {
		return gemNum;
	}
	public void setGemNum(int gemNum) {
		this.gemNum = gemNum;
	}
	public int getCrownNum() {
		return crownNum;
	}
	public void setCrownNum(int crownNum) {
		this.crownNum = crownNum;
	}
	public int getGoldNum() {
		return goldNum;
	}
	public void setGoldNum(int goldNum) {
		this.goldNum = goldNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getAddUpMoney() {
		return addUpMoney;
	}

	public void setAddUpMoney(long addUpMoney) {
		this.addUpMoney = addUpMoney;
	}

	public int getTypeKe() {
		return typeKe;
	}

	public void setTypeKe(int typeKe) {
		this.typeKe = typeKe;
	}

	public Date getTypeKeTime() {
		return typeKeTime;
	}

	public void setTypeKeTime(Date typeKeTime) {
		this.typeKeTime = typeKeTime;
	}
	
}
