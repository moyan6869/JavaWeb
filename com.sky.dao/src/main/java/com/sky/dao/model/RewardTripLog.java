/**   
* @Title: RewardTripLog.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 海外旅游奖明细bean
* @author zenglinhua
* @date 2016年1月14日 下午7:01:39
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: RewardTripLog 
 * @Description: 海外旅游奖明细bean
 * @author zenglinhua
 * @date 2016年1月14日 下午7:01:39 
 *  
 */
public class RewardTripLog  implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = -6700120118464238642L;

	/**
	 * 主键
	 */
	private String tripLogId;
	
	/**
	 * 用户id
	 */
	private String memberId;
	
	/**
	 * 冠级别
	 */
	private int crownType;
	
	/**
	 * 月份
	 */
	private int month;
	
	/**
	 * 奖励金额
	 */
	private long money;
	
	/**
	 * 状态
	 */
	private int status;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 删除标示
	 */
	private int deleteFlag;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public String getTripLogId() {
		return tripLogId;
	}

	public void setTripLogId(String tripLogId) {
		this.tripLogId = tripLogId;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "RewardTripLog [tripLogId=" + tripLogId + ", memberId="
				+ memberId + ", crownType=" + crownType + ", month=" + month
				+ ", money=" + money + ", status=" + status + ", createDate="
				+ createDate + ", deleteFlag=" + deleteFlag + ", updateDate="
				+ updateDate + "]";
	}
	
	
}
