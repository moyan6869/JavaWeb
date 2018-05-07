package com.sky.dao.vo;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: Kanger
 * @Description: 会员积分
 * * @Date: 2016/12/6 9:40
 */
public class MemberScoreBean {
    private String memberId;
    private long totalScore;

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
}
