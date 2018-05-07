package com.sky.dao.model;

/**
 * Created by weiyunliang on 2017/8/7.
 */
public class CalcBean {
    int TAG=0;
    int amount=0;

    public int getTAG() {
        return TAG;
    }

    public void setTAG(int TAG) {
        this.TAG = TAG;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CalcBean{" +
                "TAG=" + TAG +
                ", amount=" + amount +
                '}';
    }
}
