/**   
* @Title: RewardLeaderMonth.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 领导奖汇总 
* @author zenglinhua
* @date 2016年1月8日 上午10:27:10
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardLeaderMonth 
 * @Description: 领导奖汇总
 * @author zenglinhua
 * @date 2016年1月8日 上午10:27:10 
 *  
 */
public class RewardLeaderMonth implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化id
	*/ 
	private static final long serialVersionUID = 6031748587048258114L;
	
	/**
	 * 主键
	 */
	private String rewardLeaderId;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 领导奖总金额
	 */
	private long leaderSumMoney;
	
	/**
	 * 月冠级用户总数
	 */
	private int memberSum;

	/**
	 * 状态
	 */
	private int status;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 更新日期（新增时等于创建日期）
	 */
	private Date updateDate;

	public String getRewardLeaderId() {
		return rewardLeaderId;
	}

	public void setRewardLeaderId(String rewardLeaderId) {
		this.rewardLeaderId = rewardLeaderId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public long getLeaderSumMoney() {
		return leaderSumMoney;
	}

	public void setLeaderSumMoney(long leaderSumMoney) {
		this.leaderSumMoney = leaderSumMoney;
	}

	public int getMemberSum() {
		return memberSum;
	}

	public void setMemberSum(int memberSum) {
		this.memberSum = memberSum;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
