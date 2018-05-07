package com.sky.dao.log;

import java.util.Date;

/**
 * Created by 叶子林 on 2016/3/16.
 */
public class MaintainMemberLogBean {
    private  String logId;
    private  String phone;
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

    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
