package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * DbMessageVo
 * @version 1.0
 */
public class DbMessageVo  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String msgId;//32位UUID
    private String memberId;//购买人ID
    private String infoId;//对于api 就是传orderId
    private Integer type;//对于api  type=1
    private Date createDate;
    private Date updateDate;//此字段 api不写

    private Integer deleteFlag;//也不写

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "DbMessageVo{" +
                "msgId='" + msgId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", infoId='" + infoId + '\'' +
                ", type=" + type +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
