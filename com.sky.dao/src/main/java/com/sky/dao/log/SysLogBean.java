package com.sky.dao.log;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 系统日志
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeName")
public class SysLogBean extends BaseLogBean {

    private static final long serialVersionUID = 1L;

    public SysLogBean() {
        super();
    }

    public SysLogBean(Integer logType, Integer sysUserId, String logData) {
        this.logType = logType;
        this.sysUserId = sysUserId;
        super.setLogData(logData);
        super.setCreateDate(new Date());
    }

    private Integer logType;

    private Integer sysUserId;

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    public String toString() {
        return "SysLogBean{" +
                "logId=" + super.getLogId() +
                ", logData='" + super.getLogData() + '\'' +
                ", logType='" + this.getLogType() + '\'' +
                ", sysUserId='" + this.getSysUserId() + '\'' +
                ", createDate=" + super.getCreateDate() +
                '}';
    }
}
