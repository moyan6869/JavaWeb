package com.sky.web.model;

import java.util.Date;

/**
 * Created by 建帆 on 2016/4/6.
 */
public class ActivityItemModel {
    private String activityItemId;
    private String activityPlanId;
    private String title;
    private String imgUrl;
    private Integer isCategory;
    private Integer isSingle;
    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Date updateDate;
    private Integer deleteFlag;

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId;
    }

    public String getActivityPlanId() {
        return activityPlanId;
    }

    public void setActivityPlanId(String activityPlanId) {
        this.activityPlanId = activityPlanId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsCategory() {
        return isCategory;
    }

    public void setIsCategory(Integer isCategory) {
        this.isCategory = isCategory;
    }

    public Integer getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(Integer isSingle) {
        this.isSingle = isSingle;
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
