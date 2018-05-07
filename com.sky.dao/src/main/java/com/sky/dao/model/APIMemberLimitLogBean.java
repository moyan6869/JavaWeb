package com.sky.dao.model;

import java.awt.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import java.util.List;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: Kanger
 * @Description: 会员返本基金额度,api返回格式
 * @Date: 2016/10/22 14:20
 */
public class APIMemberLimitLogBean {

    private int sumScore;
    private int returnSumMoney;

    private List<MemberLimitLogBean> memberLimitLogBeanList;

    private List<ReBackFundMemberFreenBean> reBackFundList;

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public int getReturnSumMoney() {
        return returnSumMoney;
    }

    public void setReturnSumMoney(int returnSumMoney) {
        this.returnSumMoney = returnSumMoney;
    }

    public List<MemberLimitLogBean> getMemberLimitLogBeanList() {
        return memberLimitLogBeanList;
    }

    public void setMemberLimitLogBeanList(List<MemberLimitLogBean> memberLimitLogBeanList) {
        this.memberLimitLogBeanList = memberLimitLogBeanList;
    }

    public List<ReBackFundMemberFreenBean> getReBackFundList() {
        return reBackFundList;
    }

    public void setReBackFundList(List<ReBackFundMemberFreenBean> reBackFundList) {
        this.reBackFundList = reBackFundList;
    }
}
