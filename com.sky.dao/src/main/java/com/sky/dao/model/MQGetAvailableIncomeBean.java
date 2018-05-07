package com.sky.dao.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/14 0014.
 */
public class MQGetAvailableIncomeBean implements Serializable{

    private boolean isGoldThree;
    private String memberId;
    private String lowerMemberId;

    private String strightUpMemberId;
    private String leftOrRight;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public boolean isGoldThree() {
        return isGoldThree;
    }

    public void setGoldThree(boolean goldThree) {
        isGoldThree = goldThree;
    }

    public String getLowerMemberId() {
        return lowerMemberId;
    }

    public void setLowerMemberId(String lowerMemberId) {
        this.lowerMemberId = lowerMemberId;
    }

    public String getStrightUpMemberId() {
        return strightUpMemberId;
    }

    public void setStrightUpMemberId(String strightUpMemberId) {
        this.strightUpMemberId = strightUpMemberId;
    }

    public String getLeftOrRight() {
        return leftOrRight;
    }

    public void setLeftOrRight(String leftOrRight) {
        this.leftOrRight = leftOrRight;
    }
}
