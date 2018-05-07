package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: Kanger
 * @Description: 会员积分
 * * @Date: 2016/12/6 9:40
 */
public class MemberScoreExtBean {
    @JsonIgnore
    private String memberId;
    private long totalScore;
    private Integer availableNum=5;
    private Integer useNum=0;
    private Object activity=new NullObjectBean();
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(long totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getAvailableNum() {
        return availableNum;
    }

    public void setAvailableNum(Integer availableNum) {
        this.availableNum = availableNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Object getActivity() {
        return activity;
    }

    public void setActivity(Object activity) {
        this.activity = activity;
    }
}
