package com.sky.dao.vo;

import java.io.Serializable;

/**
 * MemberYundeBean
 * @version 1.0
 * @author dao
 */ 
public class MemberYundeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String phone;
	private String userName;
	private String identityCard;
	private Integer baodanMoney;
	private String referrerUserName;
	private String referrerPhone;
	private Integer status;
	private String desc;
	private String memberId;
	private String referrerMemberId;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getIdentityCard(){
		return identityCard;
	}
	public void setIdentityCard(String identityCard){
		this.identityCard = identityCard;
	}
	public Integer getBaodanMoney(){
		return baodanMoney;
	}
	public void setBaodanMoney(Integer baodanMoney){
		this.baodanMoney = baodanMoney;
	}
	public String getReferrerUserName(){
		return referrerUserName;
	}
	public void setReferrerUserName(String referrerUserName){
		this.referrerUserName = referrerUserName;
	}
	public String getReferrerPhone(){
		return referrerPhone;
	}
	public void setReferrerPhone(String referrerPhone){
		this.referrerPhone = referrerPhone;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReferrerMemberId() {
		return referrerMemberId;
	}
	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}

}

