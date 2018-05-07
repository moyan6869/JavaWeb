package com.sky.dao.model;

import com.sky.dao.vo.MemberBean;

import java.io.Serializable;
import java.util.Date;

public class MemberAchivementMonth implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795086012083293807L;

	private String achivementId;
	private String memberId;
	private String referrerMemberId;
	private String crowReferrerMemberId;
	private int silverNum;
	private int achivementNum;
	private int kingcrownNum;
	private int silverCrown;
	private String silverCrownUp;
	private long monthSumMoney;
	private long monthSumSignMoney;
	private long monthSumShopMoney;
	private int monthMeMoney;
	private long monthMeSignMoney;
	private long monthMeShopMoney;
	private int month;
	private Date createDate;
	private Date updateDate;
	private int deleteFlag;

	/**
	 * 会员
	 */
	private MemberBean memberBean;

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
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

	public long getMonthMeSignMoney() {
		return monthMeSignMoney;
	}

	public void setMonthMeSignMoney(long monthMeSignMoney) {
		this.monthMeSignMoney = monthMeSignMoney;
	}

	public long getMonthMeShopMoney() {
		return monthMeShopMoney;
	}

	public void setMonthMeShopMoney(long monthMeShopMoney) {
		this.monthMeShopMoney = monthMeShopMoney;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getSilverNum() {
		return silverNum;
	}

	public void setSilverNum(int silverNum) {
		this.silverNum = silverNum;
	}

	public int getAchivementNum() {
		return achivementNum;
	}

	public void setAchivementNum(int achivementNum) {
		this.achivementNum = achivementNum;
	}

	public String getAchivementId() {
		return achivementId;
	}

	public void setAchivementId(String achivementId) {
		this.achivementId = achivementId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReferrerMemberId() {
		return referrerMemberId;
	}

	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}

	public int getSilverCrown() {
		return silverCrown;
	}

	public void setSilverCrown(int silverCrown) {
		this.silverCrown = silverCrown;
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

	public int getMonthMeMoney() {
		return monthMeMoney;
	}

	public void setMonthMeMoney(int monthMeMoney) {
		this.monthMeMoney = monthMeMoney;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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

	public String getCrowReferrerMemberId() {
		return crowReferrerMemberId;
	}

	public void setCrowReferrerMemberId(String crowReferrerMemberId) {
		this.crowReferrerMemberId = crowReferrerMemberId;
	}

	/**
	 * 
	 * @Title: getCrowType @Description: 获取冠级别 @author zenglinhua @date
	 * 2016年1月6日 上午11:56:31 @param @return 设定文件 @return int 返回类型 @throws
	 */
	public int getCrowType() {
		int crowType = 0;
		if (this.getSilverNum() >= 5) {// 皇冠
			crowType = 3;
		} else if (this.getSilverNum() >= 3 && this.getSilverNum() < 5) {// 金冠
			crowType = 2;
		} else if (this.getAchivementNum() >= 5 && this.getSilverNum() < 3) {// 银冠
			crowType = 1;
		}
		return crowType;
	}

	@Override
	public String toString() {
		return "MemberAchivementMonth [achivementId=" + achivementId + ", memberId=" + memberId + ", referrerMemberId="
				+ referrerMemberId + ", crowReferrerMemberId=" + crowReferrerMemberId + ", silverNum=" + silverNum
				+ ", achivementNum=" + achivementNum + ", silverCrown=" + silverCrown + ", silverCrownUp="
				+ silverCrownUp + ", monthSumMoney=" + monthSumMoney + ", monthSumSignMoney=" + monthSumSignMoney
				+ ", monthSumShopMoney=" + monthSumShopMoney + ", monthMeMoney=" + monthMeMoney + ", monthMeSignMoney="
				+ monthMeSignMoney + ", monthMeShopMoney=" + monthMeShopMoney + ", month=" + month + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", deleteFlag=" + deleteFlag + "]";
	}

	public int getKingcrownNum() {
		return kingcrownNum;
	}

	public void setKingcrownNum(int kingcrownNum) {
		this.kingcrownNum = kingcrownNum;
	}

}
