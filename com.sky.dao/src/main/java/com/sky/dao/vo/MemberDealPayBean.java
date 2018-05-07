package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberDealPayBean
 *
 * @author qiujingwang
 * @version 1.0
 */
public class MemberDealPayBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String payId;
    private String payCode;
    private String currency;
    private String recAccount;
    private String recUser;
    private String payAccount;
    private String payUser;
    private String payMoneyStr;
    private Integer payMoney;
    private String payUse;
    private String bankStatus;
    private Integer dealStatus;
    private String payRemark;
    private String payType;
    private String sendMsgStr;
    private Integer sendMsg;
    private String failReason;
    private Integer checkResult;
    private Date createDate;
    private Date updateDate;
    private Integer deleteFlag;
    private String dealId;

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRecAccount() {
        return recAccount;
    }

    public void setRecAccount(String recAccount) {
        this.recAccount = recAccount;
    }

    public String getRecUser() {
        return recUser;
    }

    public void setRecUser(String recUser) {
        this.recUser = recUser;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayUse() {
        return payUse;
    }

    public void setPayUse(String payUse) {
        this.payUse = payUse;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
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

	public String getBankStatus() {
		return bankStatus;
	}

	public void setBankStatus(String bankStatus) {
		this.bankStatus = bankStatus;
	}

	public String getSendMsgStr() {
		return sendMsgStr;
	}

	public void setSendMsgStr(String sendMsgStr) {
		this.sendMsgStr = sendMsgStr;
	}

	public Integer getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(Integer sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getPayMoneyStr() {
		return payMoneyStr;
	}

	public void setPayMoneyStr(String payMoneyStr) {
		this.payMoneyStr = payMoneyStr;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
}
