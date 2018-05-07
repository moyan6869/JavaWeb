package com.sky.dao.log;

import java.util.Date;

/**
 * Created by 建帆 on 2016/3/10.
 */
public class MaintainOrderLogBean {
    private  String logId;
    private  String orderCode;
    private  int maintainType;
    private  String oldContent;
    private  String newContent;
    private  String opreation;
    private Date opreationDate;

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

    public int getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(int maintainType) {
        this.maintainType = maintainType;
    }

    public String getOldContent() {
        return oldContent;
    }

    public void setOldContent(String oldContent) {
        this.oldContent = oldContent;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    public String getOpreation() {
        return opreation;
    }

    public void setOpreation(String opreation) {
        this.opreation = opreation;
    }

    public Date getOpreationDate() {
        return opreationDate;
    }

    public void setOpreationDate(Date opreationDate) {
        this.opreationDate = opreationDate;
    }
}
