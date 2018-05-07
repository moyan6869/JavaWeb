package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class MemberStatsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户类型
     */
    private String memberType;

    /**
     * 新增人数（格式化）
     */
    private String addMemberCountStr;

    /**
     * 新增人数
     */
    private BigInteger addMemberCount = BigInteger.ZERO;

    /**
     * 升级人数（格式化）
     */
    private String promoteMemberCountStr;

    /**
     * 升级人数
     */
    private BigInteger promoteMemberCount = BigInteger.ZERO;

    /**
     * 收益活跃（月）（格式化）
     */
    private String profitActiveMemberCountStr;

    /**
     * 收益活跃（月）
     */
    private BigInteger profitActiveMemberCount = BigInteger.ZERO;

    /**
     * 收益活跃（年）（格式化）
     */
    private String profitActiveMemberYearStr;

    /**
     * 收益活跃（年）
     */
    private BigInteger profitActiveMemberYear = BigInteger.ZERO;

    /**
     * 收益活跃率
     */
    private String profitActiveRate;

    /**
     * 活跃用户（格式化）
     */
    private String activeMemberCountStr;

    /**
     * 活跃用户
     */
    private BigInteger activeMemberCount = BigInteger.ZERO;

    /**
     * 活跃率
     */
    private String activeMemberRate;

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getAddMemberCountStr() {
        return addMemberCountStr;
    }

    public void setAddMemberCountStr(String addMemberCountStr) {
        this.addMemberCountStr = addMemberCountStr;
    }

    public BigInteger getAddMemberCount() {
        return addMemberCount;
    }

    public void setAddMemberCount(BigInteger addMemberCount) {
        this.addMemberCount = addMemberCount;
    }

    public String getPromoteMemberCountStr() {
        return promoteMemberCountStr;
    }

    public void setPromoteMemberCountStr(String promoteMemberCountStr) {
        this.promoteMemberCountStr = promoteMemberCountStr;
    }

    public BigInteger getPromoteMemberCount() {
        return promoteMemberCount;
    }

    public void setPromoteMemberCount(BigInteger promoteMemberCount) {
        this.promoteMemberCount = promoteMemberCount;
    }

    public String getProfitActiveMemberCountStr() {
        return profitActiveMemberCountStr;
    }

    public void setProfitActiveMemberCountStr(String profitActiveMemberCountStr) {
        this.profitActiveMemberCountStr = profitActiveMemberCountStr;
    }

    public BigInteger getProfitActiveMemberCount() {
        return profitActiveMemberCount;
    }

    public void setProfitActiveMemberCount(BigInteger profitActiveMemberCount) {
        this.profitActiveMemberCount = profitActiveMemberCount;
    }

    public String getProfitActiveMemberYearStr() {
        return profitActiveMemberYearStr;
    }

    public void setProfitActiveMemberYearStr(String profitActiveMemberYearStr) {
        this.profitActiveMemberYearStr = profitActiveMemberYearStr;
    }

    public BigInteger getProfitActiveMemberYear() {
        return profitActiveMemberYear;
    }

    public void setProfitActiveMemberYear(BigInteger profitActiveMemberYear) {
        this.profitActiveMemberYear = profitActiveMemberYear;
    }

    public String getProfitActiveRate() {
        return profitActiveRate;
    }

    public void setProfitActiveRate(String profitActiveRate) {
        this.profitActiveRate = profitActiveRate;
    }

    public String getActiveMemberCountStr() {
        return activeMemberCountStr;
    }

    public void setActiveMemberCountStr(String activeMemberCountStr) {
        this.activeMemberCountStr = activeMemberCountStr;
    }

    public BigInteger getActiveMemberCount() {
        return activeMemberCount;
    }

    public void setActiveMemberCount(BigInteger activeMemberCount) {
        this.activeMemberCount = activeMemberCount;
    }

    public String getActiveMemberRate() {
        return activeMemberRate;
    }

    public void setActiveMemberRate(String activeMemberRate) {
        this.activeMemberRate = activeMemberRate;
    }
}
