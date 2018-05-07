package com.sky.dao.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 活动订单
 */
public class ActivityOrderVo implements Serializable {

    //活动id
    private String activityItemId = null;

    //封装订单主表
    private DoingOrderBean doingOrder;

    //封装订单子表
    private List<DoingOrder1Bean> subDoingOrderList;

    /**
     * 活动产品
     */
    private List<ActivityProduct> activityProducts;

    public DoingOrderBean getDoingOrder() {
        return doingOrder;
    }

    public void setDoingOrder(DoingOrderBean doingOrder) {
        this.doingOrder = doingOrder;
    }

    public List<DoingOrder1Bean> getSubDoingOrderList() {
        return subDoingOrderList;
    }

    public void setSubDoingOrderList(List<DoingOrder1Bean> subDoingOrderList) {
        this.subDoingOrderList = subDoingOrderList;
    }

    public List<ActivityProduct> getActivityProducts() {
        return activityProducts;
    }

    public void setActivityProducts(List<ActivityProduct> activityProducts) {
        this.activityProducts = activityProducts;
    }

    public String getActivityItemId() {
        return activityItemId;
    }

    public void setActivityItemId(String activityItemId) {
        this.activityItemId = activityItemId;
    }
}