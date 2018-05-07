package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: Kanger
 * @Description: 预存款升级信息
 * @Date: 2017/3/24 17:50
 */
public class APIUpMoneyBean {
    @JsonIgnore
    private Integer currentLevel=0;
    @JsonIgnore
    private Integer nextLevel=1;
    @JsonIgnore
    private String currentLevelStr;
    private String nextLevelStr;
    private long upMoney;

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Integer nextLevel) {
        this.nextLevel = nextLevel;
    }

    public String getCurrentLevelStr() {
        return currentLevelStr;
    }

    public void setCurrentLevelStr(String currentLevelStr) {
        this.currentLevelStr = currentLevelStr;
    }

    public String getNextLevelStr() {
        return nextLevelStr;
    }

    public void setNextLevelStr(String nextLevelStr) {
        this.nextLevelStr = nextLevelStr;
    }

    public long getUpMoney() {
        return upMoney;
    }

    public void setUpMoney(long upMoney) {
        this.upMoney = upMoney;
    }
}
