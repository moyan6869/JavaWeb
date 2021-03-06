/**   
* @Title: RewardCashLog.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 全球分红奖明细bean
* @author zenglinhua
* @date 2016年1月14日 下午7:27:27
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardCashLog 
 * @Description: 全球分红奖明细bean
 * @author zenglinhua
 * @date 2016年1月14日 下午7:27:27 
 *  
 */
public class RewardCashLog implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = -5890438479109470565L;
	
	/**
	 * 主键
	 */
	private String cashLogId;
	
	/**
	 * 用户id
	 */
	private String memberId;
	
	/**
	 * 冠级别
	 */
	private int crownType;
	
	/**
	 * 用户月业绩总额
	 */
	private long achivementMoney;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 全球分红奖励金额
	 */
	private long money;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 状态
	 */
	private int status;
	
	/**
	 * 删除标示
	 */
	private int deleteFlag;
	
	/**
	 * 创建时间
	 */
	private Date createDate;

	public String getCashLogId() {
		return cashLogId;
	}

	public void setCashLogId(String cashLogId) {
		this.cashLogId = cashLogId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getCrownType() {
		return crownType;
	}

	public void setCrownType(int crownType) {
		this.crownType = crownType;
	}

	public long getAchivementMoney() {
		return achivementMoney;
	}

	public void setAchivementMoney(long achivementMoney) {
		this.achivementMoney = achivementMoney;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "RewardCashLog [cashLogId=" + cashLogId + ", memberId="
				+ memberId + ", crownType=" + crownType + ", achivementMoney="
				+ achivementMoney + ", month=" + month + ", money=" + money
				+ ", updateDate=" + updateDate + ", status=" + status
				+ ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ "]";
	}
	
	
}
