/**   
* @Title: RewardLeaderLog.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 领导奖提成明细
* @author zenglinhua
* @date 2016年1月8日 上午10:03:45
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardLeaderLog 
 * @Description: 领导奖提成明细 
 * @author zenglinhua
 * @date 2016年1月8日 上午10:03:45 
 *  
 */
public class RewardLeaderLog implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化id 
	*/ 
	private static final long serialVersionUID = 1390765561864923400L;

	/**
	 * 主键
	 */
	private String leaderId;
	
	/**
	 * 用户id
	 */
	private String memberId;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 计算提成来源的用户id
	 */
	private String crownMemberId;
	
	/**
	 * 计算提成来源的用户月业绩
	 */
	private long achivement;
	
	/**
	 * 计算提成需要扣除的月业绩
	 */
	private long achivementReduce;
	
	/**
	 * 第几代提成
	 */
	private int level;
	
	/**
	 * 提成金额
	 */
	private long money;
	
	/**
	 * 提成状态
	 */
	private int status;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 删除标示
	 */
	private int deleteFalg;
	
	/**
	 * 更新日期（新增时等于创建日期）
	 */
	private Date updateDate;

	public String getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getCrownMemberId() {
		return crownMemberId;
	}

	public void setCrownMemberId(String crownMemberId) {
		this.crownMemberId = crownMemberId;
	}

	public long getAchivement() {
		return achivement;
	}

	public void setAchivement(long achivement) {
		this.achivement = achivement;
	}

	public long getAchivementReduce() {
		return achivementReduce;
	}

	public void setAchivementReduce(long achivementReduce) {
		this.achivementReduce = achivementReduce;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
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

	public int getDeleteFalg() {
		return deleteFalg;
	}

	public void setDeleteFalg(int deleteFalg) {
		this.deleteFalg = deleteFalg;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
