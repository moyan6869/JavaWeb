package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动奖品item
 */
public class ActivityItemVo implements Serializable{
    /**
    * 细分活动ID
    */
    private String activityItemId;

    /**
    * 分活动描述
    */
    private String title;

    /**
    * 图片地址
    */
    private String imgUrl;

    /**
    * 开始时间
    */
    private Date startDate;

    /**
    * 结束时间
    */
    private Date endDate;

    /**
     * 是否有资格，0没有，1，可以领取
     */
    private int isQualify;

    /**
     * 领奖状态 0，未领取，1，已领取
     */
    private int isGet;

    /**
     * 是否有产品分类（0,无分类   1、有分类）
     */
    private int isCategory;

    /**
     * 是否单选（0、单选，1、多选）
     */
    private int isSingle;

    private Long totalMoney;//活动总金额

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId == null ? null : activityItemId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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

    public int getIsQualify() {
        return isQualify;
    }

    public void setIsQualify(int isQualify) {
        this.isQualify = isQualify;
    }

    public int getIsGet() {
        return isGet;
    }

    public void setIsGet(int isGet) {
        this.isGet = isGet;
    }

    public int getIsCategory() {
        return isCategory;
    }

    public void setIsCategory(int isCategory) {
        this.isCategory = isCategory;
    }

    public int getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(int isSingle) {
        this.isSingle = isSingle;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        if(totalMoney == null){
            totalMoney = 0L;
        }
        this.totalMoney = totalMoney;
    }
}