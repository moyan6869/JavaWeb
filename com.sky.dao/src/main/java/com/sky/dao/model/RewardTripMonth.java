/**   
* @Title: RewardTripMonth.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 海外旅游奖月表bean
* @author zenglinhua
* @date 2016年1月14日 下午7:06:43
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardTripMonth 
 * @Description: 海外旅游奖月表bean
 * @author zenglinhua
 * @date 2016年1月14日 下午7:06:43 
 *  
 */
public class RewardTripMonth implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = 7473125708378146844L;
	
	/**
	 * 主键
	 */
	private String rewardTripId;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 月总业绩
	 */
	private long achivementSumMoney;
	
	/**
	 * 计算海外旅游奖的基数金额
	 */
	private long tripSumMoney;
	
	/**
	 * 分配海外旅游奖的会员数
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

	public String getRewardTripId() {
		return rewardTripId;
	}

	public void setRewardTripId(String rewardTripId) {
		this.rewardTripId = rewardTripId;
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

	public long getTripSumMoney() {
		return tripSumMoney;
	}

	public void setTripSumMoney(long tripSumMoney) {
		this.tripSumMoney = tripSumMoney;
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

	@Override
	public String toString() {
		return "RewardTripMonth [rewardTripId=" + rewardTripId + ", month="
				+ month + ", achivementSumMoney=" + achivementSumMoney
				+ ", tripSumMoney=" + tripSumMoney + ", memberNum=" + memberNum
				+ ", updateDate=" + updateDate + ", status=" + status
				+ ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ "]";
	}
	
}
