package com.sky.dao.vo;

import java.io.Serializable;

/**
 * 收益数据校验bean
 * Created by zhangcp on 2016/4/21.14:17
 */
public class OrderAndAchivementValidationBean implements Serializable {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单总价格（含运费）
     */
    private Integer totalMoney;
    /**
     * 运费
     */
    private Integer freight;
    /**
     * 业绩表中的订单金额（不含运费）
     */
    private Integer orderMoney;
    /**
     * 业绩id
     */
    private String achivementId;
    /**
     * 业绩记录删除标志(0为未删除)
     */
    private Integer achivementDeleteFlag;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getAchivementId() {
        return achivementId;
    }

    public void setAchivementId(String achivementId) {
        this.achivementId = achivementId;
    }

    public Integer getAchivementDeleteFlag() {
        return achivementDeleteFlag;
    }

    public void setAchivementDeleteFlag(Integer achivementDeleteFlag) {
        this.achivementDeleteFlag = achivementDeleteFlag;
    }
}
