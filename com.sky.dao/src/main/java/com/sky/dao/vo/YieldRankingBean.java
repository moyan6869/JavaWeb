package com.sky.dao.vo;

import java.text.DecimalFormat;

/**
 * 收益率排行Vo
 * Created by zhangcp on 2016/5/6.17:52
 */
public class YieldRankingBean {
    /**
     * 会员id
     */
    private String memberId;
    /**
     * 收益率=得到的收益/用户业绩
     */
    private double yield;
    /**
     * 会员姓名
     */
    private String userName;
    /**
     * 会员手机号
     */
    private String phone;
    /**
     * 运营系统id
     */
    private String osId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public double getYield() {
        return yield;
    }
    public String getYieldPercent(){
        DecimalFormat df = new DecimalFormat("##.00%");
        return df.format(yield);
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }
}
