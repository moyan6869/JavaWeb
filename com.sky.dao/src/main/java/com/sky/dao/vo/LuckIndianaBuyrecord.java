package com.sky.dao.vo;

import com.sky.dao.model.ProductDetail;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/21 0021.
 */
public class LuckIndianaBuyrecord implements Serializable{

    private int code;
    private String msg;
    private String buyId;
    private String luckId;
    private String memberId;
    private String productId;
    private int buyNumber;
    private int luckProductIndex;
    private int isPay;
    private int payType;
    private int isSend;
    private String payCode;
    private String refOrderCode;
    private Date payDate;
    private Date createDate;
    private Date updateDate;
    private int isDraw;
    private int isLottery;
    private int payMoney;
    private String luckManName;
    private String stat;
    private String statStr;
    private ProductDetail productDetail;

    public String getStatStr() {
        return statStr;
    }

    public void setStatStr(String statStr) {
        this.statStr = statStr;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public String getLuckId() {
        return luckId;
    }

    public void setLuckId(String luckId) {
        this.luckId = luckId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public int getLuckProductIndex() {
        return luckProductIndex;
    }

    public void setLuckProductIndex(int luckProductIndex) {
        this.luckProductIndex = luckProductIndex;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getRefOrderCode() {
        return refOrderCode;
    }

    public void setRefOrderCode(String refOrderCode) {
        this.refOrderCode = refOrderCode;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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

    public int getIsDraw() {
        return isDraw;
    }

    public void setIsDraw(int isDraw) {
        this.isDraw = isDraw;
    }

    public int getIsLottery() {
        return isLottery;
    }

    public void setIsLottery(int isLottery) {
        this.isLottery = isLottery;
    }

    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    public String getLuckManName() {
        return luckManName;
    }

    public void setLuckManName(String luckManName) {
        this.luckManName = luckManName;
    }
}
