package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberLuckDrawBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class MemberLuckDrawBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String drawId;
	@JsonIgnore
	private String memberId;
	private Integer status;
	private String statusStr;
	private Integer useScore;
	private String prizeName;
	private String prizeImg;
	@JsonIgnore
	private String prizeId;
	private String productId;
	private Integer prizeType;
	private Date acceptPrizeDate;
	private String contact;
	private String phone;
	private String address;
	private String expressName;
	private String expressCode;
	@JsonIgnore
	private String drawData;
	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	@JsonIgnore
	private Integer deleteFlag;

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getDrawId(){
		return drawId;
	}
	public void setDrawId(String drawId){
		this.drawId = drawId;
	}
	public String getMemberId(){
		return memberId;
	}
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getUseScore(){
		return useScore;
	}
	public void setUseScore(Integer useScore){
		this.useScore = useScore;
	}
	public String getPrizeName(){
		return prizeName;
	}
	public void setPrizeName(String prizeName){
		this.prizeName = prizeName;
	}

	public String getPrizeImg() {
		return prizeImg;
	}

	public void setPrizeImg(String prizeImg) {
		this.prizeImg = prizeImg;
	}

	public String getPrizeId(){
		return prizeId;
	}
	public void setPrizeId(String prizeId){
		this.prizeId = prizeId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getPrizeType(){
		return prizeType;
	}
	public void setPrizeType(Integer prizeType){
		this.prizeType = prizeType;
	}
	public Date getAcceptPrizeDate(){
		return acceptPrizeDate;
	}
	public void setAcceptPrizeDate(Date acceptPrizeDate){
		this.acceptPrizeDate = acceptPrizeDate;
	}
	public String getContact(){
		return contact;
	}
	public void setContact(String contact){
		this.contact = contact;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getExpressName(){
		return expressName;
	}
	public void setExpressName(String expressName){
		this.expressName = expressName;
	}
	public String getExpressCode(){
		return expressCode;
	}
	public void setExpressCode(String expressCode){
		this.expressCode = expressCode;
	}
	public String getDrawData(){
		return drawData;
	}
	public void setDrawData(String drawData){
		this.drawData = drawData;
	}
	public Date getCreateDate(){
		return createDate;
	}
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	public Integer getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
	}

}

