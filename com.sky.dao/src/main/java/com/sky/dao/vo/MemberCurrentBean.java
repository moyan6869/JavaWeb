package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/17 0017.
 */
public class MemberCurrentBean implements Serializable{
    private int meJoinMoney;
    private Date shopDay;
    private Long leftJoinMoney;//安置左区业绩
    private Long rightJoinMoney;//安置右区业绩
    private Long systemPresentMoney;//系统赠送业绩




    public Date getShopDay() {
        return shopDay;
    }

    public void setShopDay(Date shop_day) {
        this.shopDay = shop_day;
    }

    public int getMeJoinMoney() {
        return meJoinMoney;
    }

    public Long getLeftJoinMoney() {
        return leftJoinMoney;
    }

    public void setLeftJoinMoney(Long leftJoinMoney) {
        this.leftJoinMoney = leftJoinMoney;
    }

    public Long getRightJoinMoney() {
        return rightJoinMoney;
    }

    public void setRightJoinMoney(Long rightJoinMoney) {
        this.rightJoinMoney = rightJoinMoney;
    }

    public Long getSystemPresentMoney() {
        return systemPresentMoney;
    }

    public void setSystemPresentMoney(Long systemPresentMoney) {
        this.systemPresentMoney = systemPresentMoney;
    }

    public void setMeJoinMoney(int meJoinMoney) {
        this.meJoinMoney = meJoinMoney;
    }
}
