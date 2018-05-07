package com.sky.dao.vo;

import java.io.Serializable;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.dao.directsale.vo
 * @company: SI Bu kanger
 * @Description: 订单交易记录vo
 * @date 2016/4/18
 */
public class OrderTradeVo implements Serializable{

    private static final long serialVersionUID = -8274938804930691612L;

    private String tradeId;
    private String wechatPayCode;
    private String businessOrderCode;
    private String orderCode;
    private String businessCode;
    private String specialBusinessCode;
    private String devicesCode;
    private String appId;
    private String tradeUserId;
    private String tradeScenario;
    private String tradeResult;
    private String tradeMoney;
    private String offsetMoney;
    private String tradeDate;
    private String tradeSuccessDate;
    private String createDate;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getWechatPayCode() {
        return wechatPayCode;
    }

    public void setWechatPayCode(String wechatPayCode) {
        this.wechatPayCode = wechatPayCode;
    }

    public String getBusinessOrderCode() {
        return businessOrderCode;
    }

    public void setBusinessOrderCode(String businessOrderCode) {
        this.businessOrderCode = businessOrderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getSpecialBusinessCode() {
        return specialBusinessCode;
    }

    public void setSpecialBusinessCode(String specialBusinessCode) {
        this.specialBusinessCode = specialBusinessCode;
    }

    public String getDevicesCode() {
        return devicesCode;
    }

    public void setDevicesCode(String devicesCode) {
        this.devicesCode = devicesCode;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTradeUserId() {
        return tradeUserId;
    }

    public void setTradeUserId(String tradeUserId) {
        this.tradeUserId = tradeUserId;
    }

    public String getTradeScenario() {
        return tradeScenario;
    }

    public void setTradeScenario(String tradeScenario) {
        this.tradeScenario = tradeScenario;
    }

    public String getTradeResult() {
        return tradeResult;
    }

    public void setTradeResult(String tradeResult) {
        this.tradeResult = tradeResult;
    }

    public String getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(String tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public String getOffsetMoney() {
        return offsetMoney;
    }

    public void setOffsetMoney(String offsetMoney) {
        this.offsetMoney = offsetMoney;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeSuccessDate() {
        return tradeSuccessDate;
    }

    public void setTradeSuccessDate(String tradeSuccessDate) {
        this.tradeSuccessDate = tradeSuccessDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
