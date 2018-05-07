package com.sky.dao.model;

import com.sky.dao.vo.ActivityOrderProductVo;

import java.io.Serializable;
import java.util.List;

/**
 * 促销奖品订单（多选）
 * Created by qiujingwang on 2016/4/7.
 */
public class APIAddPrizesOrderBean implements Serializable{
    private String addressId;//地址
    private List<ActivityOrderProductVo> activityProducts;//活动促销商品
    private Integer orderFrom;//订单来源（1：安卓；2：苹果；3：微信）
    private String remark;//备注

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public List<ActivityOrderProductVo> getActivityProducts() {
        return activityProducts;
    }

    public void setActivityProducts(List<ActivityOrderProductVo> activityProducts) {
        this.activityProducts = activityProducts;
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