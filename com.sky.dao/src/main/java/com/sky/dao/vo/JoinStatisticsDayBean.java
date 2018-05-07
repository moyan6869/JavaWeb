package com.sky.dao.vo;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 每日业绩表
 * @Date: 2016/9/29 14:51
 */
public class JoinStatisticsDayBean {
    private String statisticsId;
    private String memberId;
    private Date day;
    private long meAchivement;
    private long leftAchivement;
    private long rightAchivement;
    private long lastLeftRemainder;//last_left_remainder
    private long lastRightRemainder;//last_right_remainder

    private Integer indexNumber = 0;

    public String getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public long getMeAchivement() {
        return meAchivement;
    }

    public void setMeAchivement(long meAchivement) {
        this.meAchivement = meAchivement;
    }

    public long getLeftAchivement() {
        return leftAchivement;
    }

    public void setLeftAchivement(long leftAchivement) {
        this.leftAchivement = leftAchivement;
    }

    public long getRightAchivement() {
        return rightAchivement;
    }

    public void setRightAchivement(long rightAchivement) {
        this.rightAchivement = rightAchivement;
    }

    public long getLastLeftRemainder() {
        return lastLeftRemainder;
    }

    public void setLastLeftRemainder(long lastLeftRemainder) {
        this.lastLeftRemainder = lastLeftRemainder;
    }

    public long getLastRightRemainder() {
        return lastRightRemainder;
    }

    public void setLastRightRemainder(long lastRightRemainder) {
        this.lastRightRemainder = lastRightRemainder;
    }

    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }
}
