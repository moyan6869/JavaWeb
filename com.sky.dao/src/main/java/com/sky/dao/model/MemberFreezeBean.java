package com.sky.dao.model;

import com.sky.dao.enums.ProfitType;
import com.sky.dao.vo.MemberBean;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class MemberFreezeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8361211910137921665L;

	private String freezeId;
	@JsonIgnore
	private BigInteger sortIndex;
	@JsonIgnore
	private String memberId;
	/**
	 * memberId所对应的会员
	 */
	private MemberBean memberBean;
	private int type;
	private String typeStr;
	private String orderId;
	@JsonIgnore
	private String orderMemberId;
	private int orderMoney;
	private int freezeProfitMoney;
	private long freezeSumMoney;
	private long profitSumMoney;

//	private int profitMonth;
	private Date profitTime;
	private int status;
	private int level;
	@JsonIgnore
	private Date createTime;
	
	private int rawStatus;

	@Override
	public String toString() {
		return "MemberFreezeBean [freezeId=" + freezeId + ", sortIndex=" + sortIndex
				+ ", memberId=" + memberId + ", memberBean=" + memberBean + ", type=" + type + ", orderId=" + orderId
				+ ", orderMemberId=" + orderMemberId +   ", orderMoney=" + orderMoney
				+ ", freezeProfitMoney=" + freezeProfitMoney + ", freezeSumMoney=" + freezeSumMoney
				+ ", profitSumMoney=" + profitSumMoney
				+ ", profitTime=" + profitTime + ", status=" + status + ", level=" + level + ", createTime="
				+ createTime + ", rawStatus=" + rawStatus
				+ "]";
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public String getFreezeId() {
		return freezeId;
	}

	public void setFreezeId(String freezeId) {
		this.freezeId = freezeId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypeStr() {
		return ProfitType.getName(type);
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
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

	public int getFreezeProfitMoney() {
		return freezeProfitMoney;
	}

	public void setFreezeProfitMoney(int freezeProfitMoney) {
		this.freezeProfitMoney = freezeProfitMoney;
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



	public Date getProfitTime() {
		return profitTime;
	}

	public void setProfitTime(Date profitTime) {
		this.profitTime = profitTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

		MemberFreezeBean that = (MemberFreezeBean) o;

		return new EqualsBuilder()
				.append(freezeId, that.freezeId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(freezeId)
				.toHashCode();
	}

	public int getRawStatus() {
		return rawStatus;
	}

	public void setRawStatus(int rawStatus) {
		this.rawStatus = rawStatus;
	}
}
