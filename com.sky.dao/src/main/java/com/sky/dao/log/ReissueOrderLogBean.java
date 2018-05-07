package com.sky.dao.log;

/**
 * Created by 建帆 on 2016/1/15.
 */
public class ReissueOrderLogBean {
    private  String logId;
    private String orderCode;
    private String createOpreation;
    private String createDate;
    private String seenExpressOpreation;
    private String seenDate;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCreateOpreation() {
        return createOpreation;
    }

    public void setCreateOpreation(String createOpreation) {
        this.createOpreation = createOpreation;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSeenExpressOpreation() {
        return seenExpressOpreation;
    }

    public void setSeenExpressOpreation(String seenExpressOpreation) {
        this.seenExpressOpreation = seenExpressOpreation;
    }

    public String getSeenDate() {
        return seenDate;
    }

    public void setSeenDate(String seenDate) {
        this.seenDate = seenDate;
    }
}
