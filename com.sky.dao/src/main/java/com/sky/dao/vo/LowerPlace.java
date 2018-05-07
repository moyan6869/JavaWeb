package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class LowerPlace implements Serializable{
    private Integer incId;
    private Integer level;
    private Integer lowerIncId;
    private Integer placeType;
    private Integer isDead;


    public Integer getIncId() {
        return incId;
    }

    public void setIncId(Integer incId) {
        this.incId = incId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLowerIncId() {
        return lowerIncId;
    }

    public void setLowerIncId(Integer lowerIncId) {
        this.lowerIncId = lowerIncId;
    }

    public Integer getPlaceType() {
        return placeType;
    }

    public void setPlaceType(Integer placeType) {
        this.placeType = placeType;
    }

    public Integer getIsDead() {
        return isDead;
    }

    public void setIsDead(Integer isDead) {
        this.isDead = isDead;
    }
}
