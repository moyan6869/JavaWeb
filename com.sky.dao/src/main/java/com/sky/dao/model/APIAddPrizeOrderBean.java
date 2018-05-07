package com.sky.dao.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 促销奖品订单
 * Created by qiujingwang on 2016/4/7.
 */
public class APIAddPrizeOrderBean implements Serializable{
    private String addressId;//地址
    private Set<String> activityProductIds;//活动促销商品ID（促销活动商品主键）
    private Integer orderFrom;//订单来源（1：安卓；2：苹果；3：微信）
    private String remark;//备注

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Set<String> getActivityProductIds() {
        return activityProductIds;
    }

    public void setActivityProductIds(Set<String> activityProductIds) {
        this.activityProductIds = activityProductIds;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}