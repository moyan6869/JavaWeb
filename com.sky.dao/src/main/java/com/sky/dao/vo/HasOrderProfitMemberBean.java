package com.sky.dao.vo;

/**
 * Created by 建帆 on 2015/12/18.
 */
public class HasOrderProfitMemberBean {
    //获得订单收益的人
    private String memberName;
    //第几个上级
    private Integer level;
    //收益产生类别
    private Integer type;
    //获取到的收益金额
    private double profitMoney;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public double getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(double profitMoney) {
        this.profitMoney = profitMoney;
    }
}
