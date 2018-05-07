package com.sky.dao.vo;

import java.io.Serializable;

/**
 * @Author: Geoffrey
 * @Packager:  com.sky.dao.vo;
 * @company: SIBU Kanger
 * @Description: 订单各状态个数
 * @Date: 2016/9/29 8:58
 */
public class OrderStatusCountBean implements Serializable {
    private Integer waitPay=0;
    private Integer waitShip=0;
    private Integer hasShip=0;
    private Integer hasComplete=0;
    private Integer afterSales=0;

    public Integer getWaitPay() {
        return waitPay;
    }

    public void setWaitPay(Integer waitPay) {
        this.waitPay = waitPay;
    }

    public Integer getWaitShip() {
        return waitShip;
    }

    public void setWaitShip(Integer waitShip) {
        this.waitShip = waitShip;
    }

    public Integer getHasShip() {
        return hasShip;
    }

    public void setHasShip(Integer hasShip) {
        this.hasShip = hasShip;
    }

    public Integer getHasComplete() {
        return hasComplete;
    }

    public void setHasComplete(Integer hasComplete) {
        this.hasComplete = hasComplete;
    }

    public Integer getAfterSales() {
        return afterSales;
    }

    public void setAfterSales(Integer afterSales) {
        this.afterSales = afterSales;
    }

    @Override
    public String toString() {
        return "OrderStatusCountBean{" +
                "waitPay=" + this.waitPay +
                ", waitShip=" + this.waitShip +
                ", hasShip=" + this.hasShip +
                ", hasComplete=" + this.hasComplete +
                ", afterSales=" + this.afterSales +
                '}';
    }
}
