package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberAccountBean
 *
 * @author dao
 * @version 1.0
 */
public class MemberAccountBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String accountId;

    @JsonIgnore()
    private String memberId;
    private String phone;
    private int accountType = 0;
    private int bankId = 0;
    private String bankAccount;
    private String bankUser;
    private String alipayAccount;
    private String alipayUser;
    private String wechatAccount;
    private String wechatUser;
    private String bankName;
    private String bankLogo;
    private int accountStatus;
    private String idcardFrontImg;
    private String idcardBackImg;
    private String idcardHeadImg;
    private String bankcardFrontImg;
    private String bankcardProvince;
    private String bankcardCity;
    private String bankcardArea;
    private String bankcardAddress;
    private String bankcardCode;
    private Date checkDate;
    private String checkResult;
    private String remark;
    private String identityCard;

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @JsonIgnore()
    private Date createDate;

    @JsonIgnore()
    private Date updateDate;

	public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankUser() {
        return bankUser;
    }

    public void setBankUser(String bankUser) {
        this.bankUser = bankUser;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getAlipayUser() {
        return alipayUser;
    }

    public void setAlipayUser(String alipayUser) {
        this.alipayUser = alipayUser;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getWechatUser() {
        return wechatUser;
    }

    public void setWechatUser(String wechatser) {
        this.wechatUser = wechatser;
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


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String bankLogo) {
        this.bankLogo = bankLogo;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getIdcardFrontImg() {
        return idcardFrontImg;
    }

    public void setIdcardFrontImg(String idcardFrontImg) {
        this.idcardFrontImg = idcardFrontImg;
    }

    public String getIdcardBackImg() {
        return idcardBackImg;
    }

    public void setIdcardBackImg(String idcardBackImg) {
        this.idcardBackImg = idcardBackImg;
    }

    public String getIdcardHeadImg() {
        return idcardHeadImg;
    }

    public void setIdcardHeadImg(String idcardHeadImg) {
        this.idcardHeadImg = idcardHeadImg;
    }

    public String getBankcardFrontImg() {
        return bankcardFrontImg;
    }

    public void setBankcardFrontImg(String bankcardFrontImg) {
        this.bankcardFrontImg = bankcardFrontImg;
    }

    public String getBankcardProvince() {
        return bankcardProvince;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setBankcardProvince(String bankcardProvince) {
        this.bankcardProvince = bankcardProvince;
    }

    public String getBankcardCity() {
        return bankcardCity;
    }

    public void setBankcardCity(String bankcardCity) {
        this.bankcardCity = bankcardCity;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getBankcardArea() {
        return bankcardArea;
    }

    public void setBankcardArea(String bankcardArea) {
        this.bankcardArea = bankcardArea;
    }

    public String getBankcardAddress() {
        return bankcardAddress;
    }

    public void setBankcardAddress(String bankcardAddress) {
        this.bankcardAddress = bankcardAddress;
    }

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    @Override
    public String toString() {
        return "MemberAccountBean{" +
                "accountId='" + accountId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", phone='" + phone + '\'' +
                ", accountType=" + accountType +
                ", bankId=" + bankId +
                ", bankAccount='" + bankAccount + '\'' +
                ", bankUser='" + bankUser + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", alipayUser='" + alipayUser + '\'' +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", wechatUser='" + wechatUser + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankLogo='" + bankLogo + '\'' +
                ", accountStatus=" + accountStatus +
                ", idcardFrontImg='" + idcardFrontImg + '\'' +
                ", idcardBackImg='" + idcardBackImg + '\'' +
                ", idcardHeadImg='" + idcardHeadImg + '\'' +
                ", bankcardFrontImg='" + bankcardFrontImg + '\'' +
                ", bankcardProvince='" + bankcardProvince + '\'' +
                ", bankcardCity='" + bankcardCity + '\'' +
                ", bankcardArea='" + bankcardArea + '\'' +
                ", bankcardAddress='" + bankcardAddress + '\'' +
                ", bankcardCode='" + bankcardCode + '\'' +
                ", checkDate=" + checkDate +
                ", checkResult='" + checkResult + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}

