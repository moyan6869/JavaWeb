package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/27 0027.
 */
public class LuckBean implements Serializable{

    private Integer totalShareNumber;
    private Integer buyNumber;
    private String buyId;

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public Integer getTotalShareNumber() {
        return totalShareNumber;
    }

    public void setTotalShareNumber(Integer totalShareNumber) {
        this.totalShareNumber = totalShareNumber;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
}
