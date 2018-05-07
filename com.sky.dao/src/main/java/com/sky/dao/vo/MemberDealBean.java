package com.sky.dao.vo;

import com.sky.dao.enums.DealStatus;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberDealBean
 *
 * @author dao
 * @version 1.0
 */
public class MemberDealBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String dealId;
    private String dealCode;
    private int dealStatus;
    private String dealStatusStr;
    private String applyMemberId;
    private String applyAccountId;
    private int applyMoney;
    private Date applyDate;
    @JsonIgnore()
    private int checkUserId;
    private Date checkDate;
    private int checkStatus;
    private String checkResult;
    @JsonIgnore()
    private int giveUserId;
    private Date giveDate;
    private String giveResult;
    private String giveInvoice;
    @JsonIgnore()
    private Date createDate;
    @JsonIgnore()
    private Date updateDate;

    private Object account;
    private int applyMonth;
    private int serviceChargeMoney;
    private int proxyTaxMoney;
    private int backMoney;
    private int giveMoney;
    private int remainderMoney;
    private int exportFlag;
    private int offsetFlag;
    private int deductTaxMoney;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public int getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(int dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getDealStatusStr() {
        return dealStatusStr;
    }

    public void setDealStatusStr(String dealStatusStr) {
        this.dealStatusStr = dealStatusStr;
    }

    public String getApplyMemberId() {
        return applyMemberId;
    }

    public void setApplyMemberId(String applyMemberId) {
        this.applyMemberId = applyMemberId;
    }

    public String getApplyAccountId() {
        return applyAccountId;
    }

    public void setApplyAccountId(String applyAccountId) {
        this.applyAccountId = applyAccountId;
    }

    public int getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(int applyMoney) {
        this.applyMoney = applyMoney;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public int getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(int checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public int getGiveUserId() {
        return giveUserId;
    }

    public void setGiveUserId(int giveUserId) {
        this.giveUserId = giveUserId;
    }

    public Date getGiveDate() {
        return giveDate;
    }

    public void setGiveDate(Date giveDate) {
        this.giveDate = giveDate;
    }

    public String getGiveResult() {
        return giveResult;
    }

    public void setGiveResult(String giveResult) {
        this.giveResult = giveResult;
    }

    public String getGiveInvoice() {
        return giveInvoice;
    }

    public void setGiveInvoice(String giveInvoice) {
        this.giveInvoice = giveInvoice;
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

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

	public int getApplyMonth() {
		return applyMonth;
	}

	public void setApplyMonth(int applyMonth) {
		this.applyMonth = applyMonth;
	}

	public int getServiceChargeMoney() {
		return serviceChargeMoney;
	}

	public void setServiceChargeMoney(int serviceChargeMoney) {
		this.serviceChargeMoney = serviceChargeMoney;
	}

	public int getProxyTaxMoney() {
		return proxyTaxMoney;
	}

	public void setProxyTaxMoney(int proxyTaxMoney) {
		this.proxyTaxMoney = proxyTaxMoney;
	}

	public int getBackMoney() {
		return backMoney;
	}

	public void setBackMoney(int backMoney) {
		this.backMoney = backMoney;
	}

	public int getGiveMoney() {
		return giveMoney;
	}

	public void setGiveMoney(int giveMoney) {
		this.giveMoney = giveMoney;
	}

	public int getRemainderMoney() {
		return remainderMoney;
	}

	public void setRemainderMoney(int remainderMoney) {
		this.remainderMoney = remainderMoney;
	}

	public int getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(int exportFlag) {
		this.exportFlag = exportFlag;
	}

	public int getOffsetFlag() {
		return offsetFlag;
	}

	public void setOffsetFlag(int offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public int getDeductTaxMoney() {
        return deductTaxMoney;
    }

	public void setDeductTaxMoney(int deductTaxMoney) {
        this.deductTaxMoney = deductTaxMoney;
	}

    public boolean deductTaxMoneyIsZero(){
        return (DealStatus.BillGiveSuccess.getCode()==this.dealStatus ||
                (DealStatus.WaitBill.getCode()==this.dealStatus && this.offsetFlag==3));
    }

    @Override
    public String toString() {
        return "MemberDealBean{" +
                "dealId='" + dealId + '\'' +
                ", dealCode='" + dealCode + '\'' +
                ", dealStatus=" + dealStatus +
                ", dealStatusStr='" + dealStatusStr + '\'' +
                ", applyMemberId='" + applyMemberId + '\'' +
                ", applyAccountId='" + applyAccountId + '\'' +
                ", applyMoney=" + applyMoney +
                ", applyDate=" + applyDate +
                ", checkUserId=" + checkUserId +
                ", checkDate=" + checkDate +
                ", checkStatus=" + checkStatus +
                ", checkResult='" + checkResult + '\'' +
                ", giveUserId=" + giveUserId +
                ", giveDate=" + giveDate +
                ", giveResult='" + giveResult + '\'' +
                ", giveInvoice='" + giveInvoice + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", account=" + account +
                ", applyMonth=" + applyMonth +
                ", serviceChargeMoney=" + serviceChargeMoney +
                ", proxyTaxMoney=" + proxyTaxMoney +
                ", backMoney=" + backMoney +
                ", giveMoney=" + giveMoney +
                ", remainderMoney=" + remainderMoney +
                ", exportFlag=" + exportFlag +
                ", offsetFlag=" + offsetFlag +
                ", deductTaxMoney=" + deductTaxMoney +
                '}';
    }
}

