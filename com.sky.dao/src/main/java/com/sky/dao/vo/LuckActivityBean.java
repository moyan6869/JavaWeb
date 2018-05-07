package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: Kanger
 * @Description: 活动实体
 * @Date: 2016/12/7 15:27
 */
public class LuckActivityBean {
    private String activityId;
    private String aname;
    private String rule;
    @JsonIgnore
    private Integer status = 0;
    private long score;
    @JsonIgnore
    private Date startDate;
    @JsonIgnore
    private Date endDate;
    private String turnImg;
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    @JsonIgnore
    private Integer deleteFlag;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTurnImg() {
        return turnImg;
    }

    public void setTurnImg(String turnImg) {
        this.turnImg = turnImg;
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
