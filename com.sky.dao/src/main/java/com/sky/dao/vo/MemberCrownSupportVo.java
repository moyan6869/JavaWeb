package com.sky.dao.vo;

import java.io.Serializable;

public class MemberCrownSupportVo  implements Serializable {

	/**
	 *  钻石特别支持奖，2016.6.30结束
	 */
	private static final long serialVersionUID = -2364925808004293766L;
	
	private String memberId;
	private String memberType;
	private int month;
	private String referrerMemberId;
	private String crownUp;
	private String achivementMoney ;
	private String reduceMoney ;
	private String discount;
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
		return "MemberCrownSupportVo [memberId=" + memberId + ", memberType=" + memberType + ", month=" + month
				+ ", referrerMemberId=" + referrerMemberId + ", crownUp=" + crownUp + ", achivementMoney="
				+ achivementMoney + ", reduceMoney=" + reduceMoney + ", discount=" + discount
				+ ", money=" + money + ", headImage=" + headImage + ", phone=" + phone + ", nickName=" + nickName
				+ ", userName=" + userName + ", wechat=" + wechat + ", isMember=" + isMember + ", appDate=" + appDate
				+ ", status=" + status + ", level=" + level + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
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
	
	public String getAchivementMoney() {
		return achivementMoney;
	}
	public void setAchivementMoney(String achivementMoney) {
		this.achivementMoney = achivementMoney;
	}
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getReduceMoney() {
		return reduceMoney;
	}
	public void setReduceMoney(String reduceMoney) {
		this.reduceMoney = reduceMoney;
	}
    
    

}
