/**   
* @Title: MemberCrowMonthVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 冠级树vo
* @author xiaoheliu
* @date 2015年12月24日 下午1:47:57
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

/** 
 * @ClassName: MemberCrowMonthVo 
 * @Description: 冠级树vo 
 * @author xiaoheliu
 * @date 2015年12月24日 下午1:47:57 
 *  
 */
public class MemberCrowMonthVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String referenceMemberId;
	private int month;
	private String crownType;
	private int achivementNum;
	private int silverNum;
	private String silverCrownUp;
	private String monthSumMoney;
	private String headImage;
    private String phone;
    private String userName;
    private String wechat;
    private Integer isMember;
    private String identityCard;
    private String appDate;
    private String profit;
    
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReferenceMemberId() {
		return referenceMemberId;
	}
	public void setReferenceMemberId(String referenceMemberId) {
		this.referenceMemberId = referenceMemberId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getCrownType() {
		return crownType;
	}
	public void setCrownType(String crownType) {
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
	
	public String getMonthSumMoney() {
		return monthSumMoney;
	}
	public void setMonthSumMoney(String monthSumMoney) {
		this.monthSumMoney = monthSumMoney;
	}
	
	public void setSilverCrownUp(String silverCrownUp) {
		this.silverCrownUp = silverCrownUp;
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
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getProfit() {
		return profit;
	}
	public void setProfit(String profit) {
		this.profit = profit;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
