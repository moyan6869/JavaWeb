/**   
* @Title: MemberBillBean.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: 用户发票信息
* @author zenglinhua
* @date 2016年1月27日 下午5:54:18
* @version V1.0
*/
package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

/** 
 * @ClassName: MemberBillBean 
 * @Description: 用户发票信息
 * @author zenglinhua
 * @date 2016年1月27日 下午5:54:18 
 *  
 */

public class MemberBillBean implements Serializable {

	private static final long serialVersionUID = 5289219626505292432L;
	
	private String billId;
	private String memberId;
	private Integer billMoney;
	private String billMoneyStr;
	private Integer billCheckUserId;
	private Date billCheckDate;
	private String billImg;
	private Integer remainderMoney;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;
	private String billCode;
	private String billNumber;
	private Integer billType;
	private String billTypeStr;
	private String taxNumber;
	private String company;
	private String remark;
	private Integer checkResult;
	private Integer billContent;
	private String billContentStr;
	
	private String phone;
	private String nickName;
	private String userName;
	private String identityCard;
	
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Integer getBillMoney() {
		return billMoney;
	}
	public void setBillMoney(Integer billMoney) {
		this.billMoney = billMoney;
	}
	public Integer getBillCheckUserId() {
		return billCheckUserId;
	}
	public void setBillCheckUserId(Integer billCheckUserId) {
		this.billCheckUserId = billCheckUserId;
	}
	public Date getBillCheckDate() {
		return billCheckDate;
	}
	public void setBillCheckDate(Date billCheckDate) {
		this.billCheckDate = billCheckDate;
	}
	public String getBillImg() {
		return billImg;
	}
	public void setBillImg(String billImg) {
		this.billImg = billImg;
	}
	public Integer getRemainderMoney() {
		return remainderMoney;
	}
	public void setRemainderMoney(Integer remainderMoney) {
		this.remainderMoney = remainderMoney;
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
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}
	public Integer getBillContent() {
		return billContent;
	}
	public void setBillContent(Integer billContent) {
		this.billContent = billContent;
	}

	public String getBillMoneyStr() {
		return billMoneyStr;
	}

	public void setBillMoneyStr(String billMoneyStr) {
		this.billMoneyStr = billMoneyStr;
	}

	public String getBillTypeStr() {
		return billTypeStr;
	}

	public void setBillTypeStr(String billTypeStr) {
		this.billTypeStr = billTypeStr;
	}

	public String getBillContentStr() {
		return billContentStr;
	}

	public void setBillContentStr(String billContentStr) {
		this.billContentStr = billContentStr;
	}
}
