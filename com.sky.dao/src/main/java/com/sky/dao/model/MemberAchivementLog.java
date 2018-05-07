package com.sky.dao.model;

import com.sky.dao.vo.MemberBean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class MemberAchivementLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4483989980989449002L;
	
	private String achivementId;
	private String achivementCode;
	private BigInteger sortIndex;
	private String memberId;
	/**
	 * memberId所对应的会员
	 */
	private MemberBean memberBean;
	private String nextMemberId;
	private String orderId;
	private String orderMemberId;
	private int		orderType;
	private int orderMoney;
	private long monthSumMoney;
	private long monthSignMoney;
	private long monthShopMoney;
	private int orderMonth;
	private int type;
	private int level;
	private Date createDate;
	private Date updateDate;
	private int deleteFlag;
	private int rawStatus;
	
	private String orderMoneyStr;
	private String monthSumMoneyStr;
	private String typeStr;
	private String relevancePhone;
	private String flowType;



	private String orderCode;
	private String orderMemberName;

	/**
	 * 会员姓名
	 */
	private String userName;
	/**
	 * 会员手机号
	 */
	private String phone;
	/**
	 * 运营系统id
	 */
	private String osId;

	
	@Override
	public String toString() {
		return "MemberAchivementLog [achivementId=" + achivementId + ", achivementCode=" + achivementCode
				+ ", sortIndex=" + sortIndex + ", memberId=" + memberId + ", orderId=" + orderId + ", orderMemberId="
				+ orderMemberId + ", orderType=" + orderType + ", orderMoney=" + orderMoney + ", monthSumMoney="
				+ monthSumMoney + ", monthSignMoney=" + monthSignMoney + ", monthShopMoney=" + monthShopMoney
				+ ", orderMonth=" + orderMonth + ", type=" + type + ", level=" + level + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", deleteFlag=" + deleteFlag + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOsId() {
		return osId;
	}

	public void setOsId(String osId) {
		this.osId = osId;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public String getAchivementId() {
		return achivementId;
	}

	public void setAchivementId(String achivementId) {
		this.achivementId = achivementId;
	}

	public String getAchivementCode() {
		return achivementCode;
	}

	public void setAchivementCode(String achivementCode) {
		this.achivementCode = achivementCode;
	}

	public BigInteger getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(BigInteger sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderMemberId() {
		return orderMemberId;
	}

	public void setOrderMemberId(String orderMemberId) {
		this.orderMemberId = orderMemberId;
	}

	public int getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}

	public long getMonthSumMoney() {
		return monthSumMoney;
	}

	public void setMonthSumMoney(long monthSumMoney) {
		this.monthSumMoney = monthSumMoney;
	}

	public int getOrderMonth() {
		return orderMonth;
	}

	public void setOrderMonth(int orderMonth) {
		this.orderMonth = orderMonth;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public long getMonthSignMoney() {
		return monthSignMoney;
	}

	public void setMonthSignMoney(long monthSignMoney) {
		this.monthSignMoney = monthSignMoney;
	}

	public long getMonthShopMoney() {
		return monthShopMoney;
	}

	public void setMonthShopMoney(long monthShopMoney) {
		this.monthShopMoney = monthShopMoney;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getOrderMoneyStr() {
		return orderMoneyStr;
	}

	public void setOrderMoneyStr(String orderMoneyStr) {
		this.orderMoneyStr = orderMoneyStr;
	}

	public String getMonthSumMoneyStr() {
		return monthSumMoneyStr;
	}

	public void setMonthSumMoneyStr(String monthSumMoneyStr) {
		this.monthSumMoneyStr = monthSumMoneyStr;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getRelevancePhone() {
		return relevancePhone;
	}

	public void setRelevancePhone(String relevancePhone) {
		this.relevancePhone = relevancePhone;
	}

	public String getFlowType() {
		return flowType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}


	public String getNextMemberId() {
		return nextMemberId;
	}

	public void setNextMemberId(String nextMemberId) {
		this.nextMemberId = nextMemberId;
	}
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMemberName() {
		return orderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}

	public int getRawStatus() {
		return rawStatus;
	}

	public void setRawStatus(int rawStatus) {
		this.rawStatus = rawStatus;
	}
}
