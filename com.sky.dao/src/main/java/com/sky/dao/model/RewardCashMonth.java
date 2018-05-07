/**   
* @Title: RewardCashMonth.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 全球分红奖月表bean
* @author zenglinhua
* @date 2016年1月14日 下午7:27:45
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardCashMonth 
 * @Description: 全球分红奖月表bean 
 * @author zenglinhua
 * @date 2016年1月14日 下午7:27:45 
 *  
 */
public class RewardCashMonth implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = -2602087134625727241L;

	/**
	 * 主键
	 */
	private String rewardCashId;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 月业绩总额
	 */
	private long achivementSumMoney;
	
	/**
	 * 用于全球分红的金额基数
	 */
	private long cashSumMoney;
	
	/**
	 * 分配全球分红奖的用户数
	 */
	private int memberNum;
	
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

	public String getRewardCashId() {
		return rewardCashId;
	}

	public void setRewardCashId(String rewardCashId) {
		this.rewardCashId = rewardCashId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getAchivementSumMoney() {
		return achivementSumMoney;
	}

	public void setAchivementSumMoney(long achivementSumMoney) {
		this.achivementSumMoney = achivementSumMoney;
	}

	public long getCashSumMoney() {
		return cashSumMoney;
	}

	public void setCashSumMoney(long cashSumMoney) {
		this.cashSumMoney = cashSumMoney;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
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
		return "RewardCashMonth [rewardCashId=" + rewardCashId + ", month="
				+ month + ", achivementSumMoney=" + achivementSumMoney
				+ ", cashSumMoney=" + cashSumMoney + ", memberNum=" + memberNum
				+ ", updateDate=" + updateDate + ", status=" + status
				+ ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ "]";
	}
	
	
}
