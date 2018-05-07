package com.sky.dao.vo;

import java.io.Serializable;

public class MemberLevelBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int levelId;
	
	private String name;
	private int cut1;
	private int cut2;
	private int cut3;
	private int cut4;
	private int cut5;
	private int cut6;
	private int cut7;
	private int cut8;
	private int cut9;

	private int serviceAwardSales;
	private int performanceAwardSales;
	private int teamSales;
	private int nosalesNum;
	private int memberNeed;
	private int activeTeamNum;
	private int activeTeamMoney;
	private int type;
	
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCut1() {
		return cut1;
	}
	public void setCut1(int cut1) {
		this.cut1 = cut1;
	}
	public int getCut2() {
		return cut2;
	}
	public void setCut2(int cut2) {
		this.cut2 = cut2;
	}
	public int getCut3() {
		return cut3;
	}
	public void setCut3(int cut3) {
		this.cut3 = cut3;
	}
	public int getCut4() {
		return cut4;
	}
	public void setCut4(int cut4) {
		this.cut4 = cut4;
	}
	public int getCut5() {
		return cut5;
	}
	public void setCut5(int cut5) {
		this.cut5 = cut5;
	}
	public int getCut6() {
		return cut6;
	}
	public void setCut6(int cut6) {
		this.cut6 = cut6;
	}
	public int getCut7() {
		return cut7;
	}
	public void setCut7(int cut7) {
		this.cut7 = cut7;
	}
	public int getCut8() {
		return cut8;
	}
	public void setCut8(int cut8) {
		this.cut8 = cut8;
	}
	public int getCut9() {
		return cut9;
	}
	public void setCut9(int cut9) {
		this.cut9 = cut9;
	}
	public int getServiceAwardSales() {
		return serviceAwardSales;
	}
	public void setServiceAwardSales(int serviceAwardSales) {
		this.serviceAwardSales = serviceAwardSales;
	}
	public int getPerformanceAwardSales() {
		return performanceAwardSales;
	}
	public void setPerformanceAwardSales(int performanceAwardSales) {
		this.performanceAwardSales = performanceAwardSales;
	}
	public int getTeamSales() {
		return teamSales;
	}
	public void setTeamSales(int teamSales) {
		this.teamSales = teamSales;
	}
	public int getNosalesNum() {
		return nosalesNum;
	}
	public void setNosalesNum(int nosalesNum) {
		this.nosalesNum = nosalesNum;
	}
	public int getMemberNeed() {
		return memberNeed;
	}
	public void setMemberNeed(int memberNeed) {
		this.memberNeed = memberNeed;
	}
	public int getActiveTeamNum() {
		return activeTeamNum;
	}
	public void setActiveTeamNum(int activeTeamNum) {
		this.activeTeamNum = activeTeamNum;
	}
	public int getActiveTeamMoney() {
		return activeTeamMoney;
	}
	public void setActiveTeamMoney(int activeTeamMoney) {
		this.activeTeamMoney = activeTeamMoney;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MemberLevelBean [levelId=" + levelId + ", name=" + name + ", cut1=" + cut1 + ", cut2=" + cut2
				+ ", cut3=" + cut3 + ", cut4=" + cut4 + ", cut5=" + cut5 + ", cut6=" + cut6 + ", cut7=" + cut7
				+ ", cut8=" + cut8 + ", cut9=" + cut9 + ", serviceAwardSales=" + serviceAwardSales
				+ ", performanceAwardSales=" + performanceAwardSales + ", teamSales=" + teamSales + ", nosalesNum="
				+ nosalesNum + ", memberNeed=" + memberNeed + ", activeTeamNum=" + activeTeamNum + ", activeTeamMoney="
				+ activeTeamMoney + ", type=" + type + "]";
	}
	
	
}
