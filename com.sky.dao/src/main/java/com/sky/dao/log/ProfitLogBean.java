package com.sky.dao.log;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 收益日志
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeName")
public class ProfitLogBean extends BaseLogBean {

    private static final long serialVersionUID = 1L;

    public ProfitLogBean() {
        super();
    }

    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "ProfitLogBean{" +
                "logId=" + super.getLogId() +
                ", logData='" + super.getLogData() + '\'' +
                ", memberId='" + this.getMemberId() + '\'' +
                ", createDate=" + super.getCreateDate() +
                '}';
    }
}
