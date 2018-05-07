package com.sky.dao.log;

import java.util.Date;

/**
 * Created by Administrator on 2016/1/3.
 */
public class SendExpressLogBean {
    private String orderCode = "";
    private int isSendExpress = 0;
    private int isSendFangwei = 0;
    private int expressType = 0;
    private String expressLog = "";
    private String fangweiLog = "";
    private Date createDate;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getIsSendExpress() {
        return isSendExpress;
    }

    public void setIsSendExpress(int isSendExpress) {
        this.isSendExpress = isSendExpress;
    }

    public int getIsSendFangwei() {
        return isSendFangwei;
    }

    public void setIsSendFangwei(int isSendFangwei) {
        this.isSendFangwei = isSendFangwei;
    }

    public int getExpressType() {
        return expressType;
    }

    public void setExpressType(int expressType) {
        this.expressType = expressType;
    }

    public String getExpressLog() {
        return expressLog;
    }

    public void setExpressLog(String expressLog) {
        this.expressLog = expressLog;
    }

    public String getFangweiLog() {
        return fangweiLog;
    }

    public void setFangweiLog(String fangweiLog) {
        this.fangweiLog = fangweiLog;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
