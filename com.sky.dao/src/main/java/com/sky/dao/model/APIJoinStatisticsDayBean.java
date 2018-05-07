package com.sky.dao.model;

import org.apache.commons.httpclient.util.DateUtil;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 每日加盟业绩
 * @Date: 2016/10/7 19:57
 */
public class APIJoinStatisticsDayBean {
    private String statisticsId;
    private String memberId;
    private Date day;
    private Integer  profitSend=0 ;
    private long meAchivement;
    private long leftAchivement;
    private long rightAchivement;
    private int indexNumber;
    private long lastLeftAchivement;
    private long lastRightAchivement;

    private long lastLeftRemainder;//last_left_remainder
    private long lastRightRemainder;//last_right_remainder
    private String performanceday;
    private Integer  leftPeopleCount=0 ;
    private Integer  rightPeopleCount=0 ;
    private Integer  leftLevel=0;
    private Integer  rightLevel=0;
    private Integer  small;






    public String getStatisticsId() {
        return statisticsId;
    }

    public String getPerformanceday() {
        return performanceday;
    }

    public void setPerformanceday(String performanceday) {
        this.performanceday = performanceday;
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
        return  day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getSmall() {
        return small;
    }

    public void setSmall(Integer small) {
        this.small = small;
    }

    public long getLastLeftAchivement() {
        return lastLeftAchivement;
    }

    public void setLastLeftAchivement(long lastLeftAchivement) {
        this.lastLeftAchivement = lastLeftAchivement;
    }

    public long getLastRightAchivement() {
        return lastRightAchivement;
    }

    public void setLastRightAchivement(long lastRightAchivement) {
        this.lastRightAchivement = lastRightAchivement;
    }

    public Integer getProfitSend() {
        return profitSend;
    }

    public void setProfitSend(Integer profitSend) {
        this.profitSend = profitSend;
    }

    public long getMeAchivement() {
        return meAchivement;
    }

    public Integer getLeftPeopleCount() {
        return leftPeopleCount;
    }

    public void setLeftPeopleCount(Integer leftPeopleCount) {
        this.leftPeopleCount = leftPeopleCount;
    }

    public Integer getRightPeopleCount() {
        return rightPeopleCount;
    }

    public void setRightPeopleCount(Integer rightPeopleCount) {
        this.rightPeopleCount = rightPeopleCount;
    }

    public Integer getLeftLevel() {
        return leftLevel;
    }

    public void setLeftLevel(Integer leftLevel) {
        this.leftLevel = leftLevel;
    }

    public Integer getRightLevel() {
        return rightLevel;
    }

    public void setRightLevel(Integer rightLevel) {
        this.rightLevel = rightLevel;
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

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
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

    @Override
    public String toString() {
        return "APIJoinStatisticsDayBean{" +
                "statisticsId='" + statisticsId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", day=" + day +
                ", profitSend=" + profitSend +
                ", meAchivement=" + meAchivement +
                ", leftAchivement=" + leftAchivement +
                ", rightAchivement=" + rightAchivement +
                ", indexNumber=" + indexNumber +
                ", lastLeftAchivement=" + lastLeftAchivement +
                ", lastRightAchivement=" + lastRightAchivement +
                ", lastLeftRemainder=" + lastLeftRemainder +
                ", lastRightRemainder=" + lastRightRemainder +
                ", performanceday='" + performanceday + '\'' +
                '}';
    }
}
