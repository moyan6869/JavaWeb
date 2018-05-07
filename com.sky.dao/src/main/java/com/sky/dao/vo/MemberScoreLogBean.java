package com.sky.dao.vo;

import com.sky.dao.enums.MemberScoreTypeEnums;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: Kanger
 * @Description: 会员积分流水记录
 * * @Date: 2016/12/6 9:40
 */
public class MemberScoreLogBean {
    private String memberId;
    private long totalScore;
    private long score;
    private int type;
    private String typeStr;

    @JsonIgnore
    private String remark;
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    @JsonIgnore
    private int deleteFlag;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(long totalScore) {
        this.totalScore = totalScore;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        return MemberScoreTypeEnums.valueOf(type).getMsg();
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
