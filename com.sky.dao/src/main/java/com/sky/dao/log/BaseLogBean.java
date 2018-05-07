package com.sky.dao.log;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Created by Administrator on 2015/11/12.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeName")
@JsonSubTypes({ 
	@JsonSubTypes.Type(value = DealLogBean.class, name = "DealLogBean"),
    @JsonSubTypes.Type(value = ProfitLogBean.class,name="ProfitLogBean"),
    @JsonSubTypes.Type(value = SysLogBean.class, name = "SysLogBean"),
    @JsonSubTypes.Type(value = TransferFailureLogBean.class, name = "TransferFailureLogBean"),
    @JsonSubTypes.Type(value = TradeLogBean.class, name = "TradeLogBean")
    })
public class BaseLogBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
	private Integer logId;

    private String logData;

    private Date createDate;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
	public String toString() {
		return "BaseLogBean [logId=" + logId + ", logData=" + logData + ", createDate=" + createDate + "]";
	}
}
