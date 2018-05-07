package com.sky.web.model;

/**
 * Created by 建帆 on 2016/4/7.
 */
public class ActivityProductExtModel extends ActivityProductModel {
    private String name;
    private Integer retailPrice;
    private String imager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }
}
