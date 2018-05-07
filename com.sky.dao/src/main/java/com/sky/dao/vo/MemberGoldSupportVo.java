package com.sky.dao.vo;

import java.io.Serializable;

public class MemberGoldSupportVo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7604078874750345361L;
	
	private String memberId;
	private String memberType;
	private int month;
	private String referrerMemberId;
	private String crownUp;
	private String achivementMoney ;
	private String achivementReduceMoney ;
	private int discount;
	private String money;
	private String headImage;
    private String phone;
    private String nickName;
    private String userName;
    private String wechat;
    private Integer isMember;
    private String appDate;
    private int status;
    private int level;
	@Override
	public String toString() {
		return "MemberGoldSupportVo [memberId=" + memberId + ", memberType=" + memberType + ", month=" + month
				+ ", referrerMemberId=" + referrerMemberId + ", crownUp=" + crownUp + ", achivementMoney="
				+ achivementMoney + ", achivementReduceMoney=" + achivementReduceMoney + ", discount=" + discount
				+ ", money=" + money + ", headImage=" + headImage + ", phone=" + phone + ", nickName=" + nickName
				+ ", userName=" + userName + ", wechat=" + wechat + ", isMember=" + isMember + ", appDate=" + appDate
				+ "]";
	}
	
	public String getAchivementMoney() {
		return achivementMoney;
	}

	public void setAchivementMoney(String achivementMoney) {
		this.achivementMoney = achivementMoney;
	}

	public String getAchivementReduceMoney() {
		return achivementReduceMoney;
	}

	public void setAchivementReduceMoney(String achivementReduceMoney) {
		this.achivementReduceMoney = achivementReduceMoney;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
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
	
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public Integer getIsMember() {
		return isMember;
	}
	public void setIsMember(Integer isMember) {
		this.isMember = isMember;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
