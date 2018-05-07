package com.sky.dao.express.yto.vo;


import java.util.*;

/**
 * 圆通系统推送给ERP(第三方系统)的报文格式节点名称
 */

public class YTORequestData {
    //单据号
    private String billNo;

    //单据类型
    private String billType;

    // 单据状态(报文中推送的是单据状态对应的数字)
    private String billStatus;

    //面单号
    private String mailNo;

    //发货时间
    private String sendTime;

    //快递公司名称
    private String expressName;

    private List<Object> orderDetails;

    private  String allBadQty;

   private String allQty;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public List<Object> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Object> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getAllBadQty() {
        return allBadQty;
    }

    public void setAllBadQty(String allBadQty) {
        this.allBadQty = allBadQty;
    }

    public String getAllQty() {
        return allQty;
    }

    public void setAllQty(String allQty) {
        this.allQty = allQty;
    }
}
