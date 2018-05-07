package com.sky.dao.vo;

import java.io.Serializable;

/**
 * 订单活动产品
 */
public class ActivityOrderProductVo implements Serializable {
    /**
    * 
    */
    private String activityProductId;

    /**
    * 产品数量
    */
    private Integer quantity;

    public String getActivityProductId() {
        return activityProductId;
    }

    public void setActivityProductId(String activityProductId) {
        this.activityProductId = activityProductId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}