package com.sky.dao.model;

import com.sky.dao.vo.MemberBean;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class MemberProfitBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152879930082099946L;
	
	private String profitId;
	private BigInteger sortIndex;
	private String profitCode;
	private String memberId;
	/**
	 * memberId所对应的会员
	 */
	private MemberBean memberBean;
	private int type;
	private String orderId;
	private String orderMemberId;
	private int  orderType;
	private int orderMoney;
	private int profitMoney;
	private long freezeSumMoney;
	private long profitSumMoney;
	private long profitSignMoney;
	private long profitShopMoney;
	
	private long availableMoney;
	private int status;
	private int level;
	private int profitMonth;
	private Date createTime;
	private Date updateDate;
	private int deleteFlag;
	
	private int rawStatus;

	/**
	 * 订单号
	 */
	private String orderCode;
	/**
	 * 下单客户
	 */
	private String OrderMemberName;

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMemberName() {
		return OrderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		OrderMemberName = orderMemberName;
	}


	@Override
	public String toString() {
		return "MemberProfitBean [profitId=" + profitId + ", sortIndex=" + sortIndex + ", profitCode=" + profitCode
				+ ", memberId=" + memberId + ", type=" + type + ", orderId=" + orderId + ", orderMemberId="
				+ orderMemberId + ", orderType=" + orderType + ", orderMoney=" + orderMoney + ", profitMoney="
				+ profitMoney + ", freezeSumMoney=" + freezeSumMoney + ", profitSumMoney=" + profitSumMoney
				+ ", profitSignMoney=" + profitSignMoney + ", profitShopMoney=" + profitShopMoney + ", availableMoney="
				+ availableMoney + ", status=" + status + ", level=" + level + ", profitMonth=" + profitMonth
				+ ", createTime=" + createTime + ", updateDate=" + updateDate + ", deleteFlag=" + deleteFlag + "]";
	}
	public String getProfitId() {
		return profitId;
	}
	public void setProfitId(String profitId) {
		this.profitId = profitId;
	}

	public BigInteger getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(BigInteger sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getProfitCode() {
		return profitCode;
	}
	public void setProfitCode(String profitCode) {
		this.profitCode = profitCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public int getProfitMoney() {
		return profitMoney;
	}
	public void setProfitMoney(int profitMoney) {
		this.profitMoney = profitMoney;
	}
	public long getFreezeSumMoney() {
		return freezeSumMoney;
	}
	public void setFreezeSumMoney(long freezeSumMoney) {
		this.freezeSumMoney = freezeSumMoney;
	}
	public long getProfitSumMoney() {
		return profitSumMoney;
	}
	public void setProfitSumMoney(long profitSumMoney) {
		this.profitSumMoney = profitSumMoney;
	}
	public long getAvailableMoney() {
		return availableMoney;
	}
	public void setAvailableMoney(long availableMoney) {
		this.availableMoney = availableMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProfitMonth() {
		return profitMonth;
	}
	public void setProfitMonth(int profitMonth) {
		this.profitMonth = profitMonth;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public long getProfitShopMoney() {
		return profitShopMoney;
	}
	public void setProfitShopMoney(long profitShopMoney) {
		this.profitShopMoney = profitShopMoney;
	}
	public long getProfitSignMoney() {
		return profitSignMoney;
	}
	public void setProfitSignMoney(long profitSignMoney) {
		this.profitSignMoney = profitSignMoney;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		MemberProfitBean that = (MemberProfitBean) o;

		return new EqualsBuilder()
				.append(profitId, that.profitId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(profitId)
				.toHashCode();
	}

	public int getRawStatus() {
		return rawStatus;
	}

	public void setRawStatus(int rawStatus) {
		this.rawStatus = rawStatus;
	}

}
