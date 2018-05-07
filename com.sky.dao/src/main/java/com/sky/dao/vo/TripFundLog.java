package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * 旅游基金明细
 * @author qiujingwang
 * @version 1.0
 * @since 1.0
 */
public class TripFundLog implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	/*private String tripFundLogId;
	@JsonIgnore
	private String memberId;*/
	private Integer type;
	private Integer money;
	/*@JsonIgnore
	private Integer sumMoney;*/
	private Integer month;
	private String monthStr;
	private String title;
	private String memo;
	/*@JsonIgnore
	private Date createDate;
	@JsonIgnore
	private Integer deleteFlag;
	@JsonIgnore
	private Date updateDate;*/

	@JsonIgnore
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public TripFundLog(){
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
	}
}

