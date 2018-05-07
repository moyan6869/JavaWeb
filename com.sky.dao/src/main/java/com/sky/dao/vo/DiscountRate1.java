package com.sky.dao.vo;


import java.util.List;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/26 0026.
 */
public class DiscountRate1 implements Serializable{

    private boolean notDiscount = true;
    private List<DiscountRate> endList;

    public boolean isNotDiscount() {
        return notDiscount;
    }

    public void setNotDiscount(boolean notDiscount) {
        this.notDiscount = notDiscount;
    }

    public List<DiscountRate> getEndList() {
        return endList;
    }

    public void setEndList(List<DiscountRate> endList) {
        this.endList = endList;
    }
}
