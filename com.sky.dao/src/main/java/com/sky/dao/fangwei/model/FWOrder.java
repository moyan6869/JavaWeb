package com.sky.dao.fangwei.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class FWOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("UserName")
    private String UserName;
    @JsonProperty("PassWord")
    private String PassWord;
    @JsonProperty("Signature")
    private String Signature;
    private String expressNoteNum;
    private String expressNum;
    private String docDate;
    private String consignee;
    private String tel;
    private String address;
    private String erpOrderNum;
    private String cardCode;
    private String cardName;
    private String erpExpressNoteType;
    private String logisticsCenter;
    private String companyCode;
    private List<FWOrderDetail> proddatalist;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String signature) {
        Signature = signature;
    }

    public String getExpressNoteNum() {
        return expressNoteNum;
    }

    public void setExpressNoteNum(String expressNoteNum) {
        this.expressNoteNum = expressNoteNum;
    }

    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getErpOrderNum() {
        return erpOrderNum;
    }

    public void setErpOrderNum(String erpOrderNum) {
        this.erpOrderNum = erpOrderNum;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getErpExpressNoteType() {
        return erpExpressNoteType;
    }

    public void setErpExpressNoteType(String erpExpressNoteType) {
        this.erpExpressNoteType = erpExpressNoteType;
    }

    public String getLogisticsCenter() {
        return logisticsCenter;
    }

    public void setLogisticsCenter(String logisticsCenter) {
        this.logisticsCenter = logisticsCenter;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public List<FWOrderDetail> getProddatalist() {
        return proddatalist;
    }

    public void setProddatalist(List<FWOrderDetail> proddatalist) {
        this.proddatalist = proddatalist;
    }
}
