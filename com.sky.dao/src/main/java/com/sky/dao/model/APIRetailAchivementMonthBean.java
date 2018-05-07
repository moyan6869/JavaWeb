package com.sky.dao.model;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/9/29 15:02
 */
public class APIRetailAchivementMonthBean {
    private String retailId;
    private String memberId;
    private int month;
    private long sumMoney;
    private long meMoney;
    private long partnerNum;
    private long silverNum;
    private long kingNum;
    private long crownNum;
    private long extMoney;
    private long me_compound_achivement;
    private long sum_compound_achivement;
    private int leader_level;
    private String leaderLevelStr;



    private Date createDate;
    private Integer indexNumber = 0;

    public int getLeader_level() {
        return leader_level;
    }

    public void setLeader_level(int leader_level) {
        this.leader_level = leader_level;
    }

    public String getRetailId() {
        return retailId;
    }

    public String getLeaderLevelStr() {
        return leaderLevelStr;
    }

    public void setLeaderLevelStr(String leaderLevelStr) {
        this.leaderLevelStr = leaderLevelStr;
    }

    public long getMe_compound_achivement() {
        return me_compound_achivement;
    }

    public void setMe_compound_achivement(long me_compound_achivement) {
        this.me_compound_achivement = me_compound_achivement;
    }

    public long getSum_compound_achivement() {
        return sum_compound_achivement;
    }

    public void setSum_compound_achivement(long sum_compound_achivement) {
        this.sum_compound_achivement = sum_compound_achivement;
    }

    public void setRetailId(String retailId) {
        this.retailId = retailId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(long sumMoney) {
        this.sumMoney = sumMoney;
    }

    public long getMeMoney() {
        return meMoney;
    }

    public void setMeMoney(long meMoney) {
        this.meMoney = meMoney;
    }

    public long getPartnerNum() {
        return partnerNum;
    }

    public void setPartnerNum(long partnerNum) {
        this.partnerNum = partnerNum;
    }

    public long getSilverNum() {
        return silverNum;
    }

    public void setSilverNum(long silverNum) {
        this.silverNum = silverNum;
    }

    public long getKingNum() {
        return kingNum;
    }

    public void setKingNum(long kingNum) {
        this.kingNum = kingNum;
    }

    public long getCrownNum() {
        return crownNum;
    }

    public void setCrownNum(long crownNum) {
        this.crownNum = crownNum;
    }

    public long getExtMoney() {
        return extMoney;
    }

    public void setExtMoney(long extMoney) {
        this.extMoney = extMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return "APIRetailAchivementMonthBean{" +
                "retailId='" + retailId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", month=" + month +
                ", sumMoney=" + sumMoney +
                ", meMoney=" + meMoney +
                ", partnerNum=" + partnerNum +
                ", silverNum=" + silverNum +
                ", kingNum=" + kingNum +
                ", crownNum=" + crownNum +
                ", extMoney=" + extMoney +
                ", me_compound_achivement=" + me_compound_achivement +
                ", sum_compound_achivement=" + sum_compound_achivement +
                ", leader_level=" + leader_level +
                ", leaderLevelStr='" + leaderLevelStr + '\'' +
                ", createDate=" + createDate +
                ", indexNumber=" + indexNumber +
                '}';
    }
}
