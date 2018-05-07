package com.sky.dao.model;

/**
 * Created by Administrator on 2015/12/1.
 */
public class APIUserLevelBean {

    /**
     * 会员当前级别
     */
    private int memberLevel;

    /**
     * 会员当前级别
     */
    private String memberCurrentLevel;

    /**
     * 会员下一个级别
     */
    private String memberNextLevel;

    /**
     * 完成下一个级别的百分比
     */
    private float memberNextLevelValue;

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemberCurrentLevel() {
        return memberCurrentLevel;
    }

    public void setMemberCurrentLevel(String memberCurrentLevel) {
        this.memberCurrentLevel = memberCurrentLevel;
    }

    public String getMemberNextLevel() {
        return memberNextLevel;
    }

    public void setMemberNextLevel(String memberNextLevel) {
        this.memberNextLevel = memberNextLevel;
    }

    public float getMemberNextLevelValue() {
        return memberNextLevelValue;
    }

    public void setMemberNextLevelValue(float memberNextLevelValue) {
        this.memberNextLevelValue = memberNextLevelValue;
    }
}
