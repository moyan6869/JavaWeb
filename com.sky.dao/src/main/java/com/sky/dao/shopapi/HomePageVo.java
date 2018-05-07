package com.sky.dao.shopapi;

import com.sky.dao.vo.FoodWareHouse;

import java.io.Serializable;
import java.math.BigDecimal;

public class HomePageVo extends FoodWareHouse implements Serializable  {

    private Long supplyCoin;

    public Long getSupplyCoin() {
        return supplyCoin;
    }

    public void setSupplyCoin(Long supplyCoin) {
        this.supplyCoin = supplyCoin;
    }

    @Override
    public String toString() {
        return "HomePageVo{" +
                "supplyCoin=" + supplyCoin +
                '}';
    }
}
