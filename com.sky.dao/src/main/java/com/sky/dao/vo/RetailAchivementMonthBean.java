package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
public class RetailAchivementMonthBean implements Serializable,Comparable{

    private String memberId;
    private BigInteger extMoney;
    private BigInteger sumMoney;
    private BigInteger meMoney;
    private int partnerNum;
    private int silverNum;
    private int kingNum;
    private int crownNum;
   private boolean show = false;
    private int sumOr = 0;//1 为sum_money 判断

    private String refMemberId;
    private Integer leaderLevel;
    private Integer downExtremeNumber;
    private String firstMemberId;
    private String secondMemberId;
    private BigInteger firstMoney;
    private BigInteger secondMoney;
    private BigInteger otherMoney;

    public BigInteger getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(BigInteger otherMoney) {
        this.otherMoney = otherMoney;
    }

    public String getFirstMemberId() {
        return firstMemberId;
    }

    public void setFirstMemberId(String firstMemberId) {
        this.firstMemberId = firstMemberId;
    }

    public String getSecondMemberId() {
        return secondMemberId;
    }

    public void setSecondMemberId(String secondMemberId) {
        this.secondMemberId = secondMemberId;
    }

    public BigInteger getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(BigInteger firstMoney) {
        this.firstMoney = firstMoney;
    }

    public BigInteger getSecondMoney() {
        return secondMoney;
    }

    public void setSecondMoney(BigInteger secondMoney) {
        this.secondMoney = secondMoney;
    }

    public String getRefMemberId() {
        return refMemberId;
    }

    public void setRefMemberId(String refMemberId) {
        this.refMemberId = refMemberId;
    }

    public Integer getLeaderLevel() {
        return leaderLevel;
    }

    public void setLeaderLevel(Integer leaderLevel) {
        this.leaderLevel = leaderLevel;
    }

    public Integer getDownExtremeNumber() {
        return downExtremeNumber;
    }

    public void setDownExtremeNumber(Integer downExtremeNumber) {
        this.downExtremeNumber = downExtremeNumber;
    }

    public BigInteger getMeMoney() {
        return meMoney;
    }

    public void setMeMoney(BigInteger meMoney) {
        this.meMoney = meMoney;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public BigInteger getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigInteger sumMoney) {
        this.sumMoney = sumMoney;
    }

    public int getSumOr() {
        return sumOr;
    }

    public void setSumOr(int sumOr) {
        this.sumOr = sumOr;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public BigInteger getExtMoney() {
        return extMoney;
    }

    public void setExtMoney(BigInteger extMoney) {
        this.extMoney = extMoney;
    }

    public int getPartnerNum() {
        return partnerNum;
    }

    public void setPartnerNum(int partnerNum) {
        this.partnerNum = partnerNum;
    }

    public int getSilverNum() {
        return silverNum;
    }

    public void setSilverNum(int silverNum) {
        this.silverNum = silverNum;
    }

    public int getKingNum() {
        return kingNum;
    }

    public void setKingNum(int kingNum) {
        this.kingNum = kingNum;
    }

    public int getCrownNum() {
        return crownNum;
    }

    public void setCrownNum(int crownNum) {
        this.crownNum = crownNum;
    }



    @Override
    public int compareTo(Object o) {
        RetailAchivementMonthBean bean = (RetailAchivementMonthBean) o;
//        //BigInteger extMoney = bean.getExtMoney();
//        BigInteger sumMoney = bean.getSumMoney();
//        if(bean.getSumOr()==0){
//            return this.getSumMoney().compareTo(sumMoney);
//        }else if(bean.getSumOr()==1){
//            return this.getPartnerNum()>(bean.getPartnerNum())?1:-1;
//        }else if(bean.getSumOr()==2){
//            return this.getSilverNum()>(bean.getSilverNum())?1:-1;
//        }else if(bean.getSumOr()==3){
//            return this.getKingNum()>(bean.getKingNum())?1:-1;
//        }else{
//            return this.getCrownNum()>(bean.getCrownNum())?1:-1;
//        }
        return this.getSumMoney().compareTo(bean.getSumMoney());
    }
}
