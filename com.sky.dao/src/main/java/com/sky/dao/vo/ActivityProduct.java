package com.sky.dao.vo;

import java.io.Serializable;

/**
 * 活动产品
 */
public class ActivityProduct implements Serializable {
    /**
    * 
    */
    private String activityProductId;

    /**
    * 活动id
    */
    private String activityItemId;

    /**
    * 
    */
    private String productId;

    /**
    * 产品数量
    */
    private Integer quantity;

    private String name;
    private String shortName;
    private Long retailPrice;//会员价格（单位：分）
    private Long marketPrice;//市场价格（单位：分）
    private String desc;
    private String remark;
    private String thumbUrl;


    public String getActivityProductId() {
        return activityProductId;
    }

    public void setActivityProductId(String activityProductId) {
        this.activityProductId = activityProductId == null ? null : activityProductId.trim();
    }

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId == null ? null : activityItemId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Long getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Long retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }
}