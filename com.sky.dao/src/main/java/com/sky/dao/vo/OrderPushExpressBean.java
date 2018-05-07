package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * OrderPushExpressBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class OrderPushExpressBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String pushId;
	private String orderId;
	private String pushCode;
	private Integer pushTimes;
	private String orderCode;
	private Integer expressId;
	private Integer orderFrom;
	private Integer pushExpressStatus;
	private String pushExpressResult;
	private Integer pushFanweiStatus;
	private String pushFanweiResult;
	private Date pushDate;
	private String opreation;
	private Long expressWeight;
	private Integer expressStatus;
	private String expressCode;
	private String expressName;
	private String cartonNo;
	private Integer cartonQuantity;
	private Date preReceiveDate;
	private Date shipDate;
	private Integer isWriteBack;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;
	private String startDt;
	private String endDt;
	private String startDt1;
	private String endDt1;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPushCode() {
		return pushCode;
	}

	public void setPushCode(String pushCode) {
		this.pushCode = pushCode;
	}

	public Integer getPushTimes() {
		return pushTimes;
	}

	public void setPushTimes(Integer pushTimes) {
		this.pushTimes = pushTimes;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public Integer getOrderFrom() {
		return orderFrom;
	}

	public void setOrderFrom(Integer orderFrom) {
		this.orderFrom = orderFrom;
	}

	public Integer getPushExpressStatus() {
		return pushExpressStatus;
	}

	public void setPushExpressStatus(Integer pushExpressStatus) {
		this.pushExpressStatus = pushExpressStatus;
	}

	public String getPushExpressResult() {
		return pushExpressResult;
	}

	public void setPushExpressResult(String pushExpressResult) {
		this.pushExpressResult = pushExpressResult;
	}

	public Integer getPushFanweiStatus() {
		return pushFanweiStatus;
	}

	public void setPushFanweiStatus(Integer pushFanweiStatus) {
		this.pushFanweiStatus = pushFanweiStatus;
	}

	public String getPushFanweiResult() {
		return pushFanweiResult;
	}

	public void setPushFanweiResult(String pushFanweiResult) {
		this.pushFanweiResult = pushFanweiResult;
	}

	public Date getPushDate() {
		return pushDate;
	}

	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}

	public String getOpreation() {
		return opreation;
	}

	public void setOpreation(String opreation) {
		this.opreation = opreation;
	}

	public Long getExpressWeight() {
		return expressWeight;
	}

	public void setExpressWeight(Long expressWeight) {
		this.expressWeight = expressWeight;
	}

	public Integer getExpressStatus() {
		return expressStatus;
	}

	public void setExpressStatus(Integer expressStatus) {
		this.expressStatus = expressStatus;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getCartonNo() {
		return cartonNo;
	}

	public void setCartonNo(String cartonNo) {
		this.cartonNo = cartonNo;
	}

	public Integer getCartonQuantity() {
		return cartonQuantity;
	}

	public void setCartonQuantity(Integer cartonQuantity) {
		this.cartonQuantity = cartonQuantity;
	}

	public Date getPreReceiveDate() {
		return preReceiveDate;
	}

	public void setPreReceiveDate(Date preReceiveDate) {
		this.preReceiveDate = preReceiveDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getIsWriteBack() {
		return isWriteBack;
	}

	public void setIsWriteBack(Integer isWriteBack) {
		this.isWriteBack = isWriteBack;
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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}



	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getStartDt1() {
		return startDt1;
	}

	public void setStartDt1(String startDt1) {
		this.startDt1 = startDt1;
	}

	public String getEndDt1() {
		return endDt1;
	}

	public void setEndDt1(String endDt1) {
		this.endDt1 = endDt1;
	}
}

