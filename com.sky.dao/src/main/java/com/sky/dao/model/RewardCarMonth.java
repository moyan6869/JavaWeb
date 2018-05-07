/**   
* @Title: RewardCarMonth.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 豪车奖月表bean
* @author zenglinhua
* @date 2016年1月14日 下午7:12:53
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardCarMonth 
 * @Description: 豪车奖月表bean
 * @author zenglinhua
 * @date 2016年1月14日 下午7:12:53 
 *  
 */
public class RewardCarMonth implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = 4496760124487944392L;
	
	/**
	 * 主键
	 */
	private String rewardCarId;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 月业绩总额
	 */
	private long achivementSumMoney;
	
	/**
	 * 用于豪车奖励的金额基数
	 */
	private long carSumMoney;
	
	/**
	 * 获得豪车奖励的用户数
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

	public String getRewardCarId() {
		return rewardCarId;
	}

	public void setRewardCarId(String rewardCarId) {
		this.rewardCarId = rewardCarId;
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

	public long getCarSumMoney() {
		return carSumMoney;
	}

	public void setCarSumMoney(long carSumMoney) {
		this.carSumMoney = carSumMoney;
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
		return "RewardCarMonth [rewardCarId=" + rewardCarId + ", month="
				+ month + ", achivementSumMoney=" + achivementSumMoney
				+ ", carSumMoney=" + carSumMoney + ", memberNum=" + memberNum
				+ ", updateDate=" + updateDate + ", status=" + status
				+ ", deleteFlag=" + deleteFlag + ", createDate=" + createDate
				+ "]";
	}
	
	
}
