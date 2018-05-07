package com.sky.dao.model;


import java.util.Date;

public class OperationSystem {

    private static final long serialVersionUID = 1L;

    private Integer osId;

    private String systemCode;

    private String systemName;

    private String topMemberId;

    private Date createDate;

    private Date updateDate;

    private Integer deleteFlag;

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getTopMemberId() {
        return topMemberId;
    }

    public void setTopMemberId(String topMemberId) {
        this.topMemberId = topMemberId;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
