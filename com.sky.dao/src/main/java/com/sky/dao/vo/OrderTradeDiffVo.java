package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.dao.directsale.vo
 * @company: SI Bu kanger
 * @Description: (订单交易记录比对)
 * @date 2016/4/20
 */
public class OrderTradeDiffVo implements Serializable {

    private static final long serialVersionUID = -8547416351429095814L;

    /**
     * 交易记录ID
     */
    private String tradeId;

    /**
     * 微信支付流水
     */
    private String wechatPayCode;

    /**
     * 商户订单号
     */
    private String businessOrderCode;

    /**
     * 云微商订单号
     */
    private String orderCode;

    /**
     * 交易场景
     */
    private Integer tradeScenario;

    /**
     * 微信支付金额
     */
    private Integer tradeMoney;

    /**
     * 微信交易时间
     */
    private Date tradeDate;

    /**
     * 云微商订单id
     */
    private String orderId;

    /**
     * 对比结果（重复支付||支付金额不一致||系统不存在该订单）
     */
    private String diffResult;

    private String memberId;
    private String phone;
    private String userName;
    private Integer orderStatus = 0;

    private Integer totalMoney = 0;
    private Integer freight = 0;
    private Integer payType = 0;
    private Integer payMoney = 0;
    private Date payDate;
    private Integer orderFrom = 0;

    private String tradeResult;

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

    public Integer getTradeScenario() {
        return tradeScenario;
    }

    public void setTradeScenario(Integer tradeScenario) {
        this.tradeScenario = tradeScenario;
    }

    public Integer getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(Integer tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDiffResult() {
        return diffResult;
    }

    public void setDiffResult(String diffResult) {
        this.diffResult = diffResult;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getTradeResult() {
        return tradeResult;
    }

    public void setTradeResult(String tradeResult) {
        this.tradeResult = tradeResult;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}
