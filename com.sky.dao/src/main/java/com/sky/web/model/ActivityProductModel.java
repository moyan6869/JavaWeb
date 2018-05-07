package com.sky.web.model;

/**
 * Created by 建帆 on 2016/4/6.
 */
public class ActivityProductModel {
    private String activityProductId;
    private String activityItemId;
    private  String activityCategoryId;
    private String productId;
    private Integer quantity;

    public String getActivityProductId() {
        return activityProductId;
    }

    public void setActivityProductId(String activityProductId) {
        this.activityProductId = activityProductId;
    }

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId;
    }

    public String getActivityCategoryId() {
        return activityCategoryId;
    }

    public void setActivityCategoryId(String activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
