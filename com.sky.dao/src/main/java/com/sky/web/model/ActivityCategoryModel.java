package com.sky.web.model;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.directSale.web.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/5/10 10:02
 */
public class ActivityCategoryModel {
    private String activityCategoryId;
    private String activityItemId;
    private String name;
    private Integer sortIndex;
    private Integer status;//0表示上架、1下架
    private String imageUrl;
    private String remark;
    private Date createDate;
    private Date updateDate;
    private Integer deleteFlag;

    public String getActivityCategoryId() {
        return activityCategoryId;
    }

    public void setActivityCategoryId(String activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
