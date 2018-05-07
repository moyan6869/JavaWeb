package com.sky.dao.vo;

import com.sky.dao.model.MemberAchivementLog;
import com.sky.dao.model.MemberFreezeBeanExt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装某个订单号(orderCode)所影响到的业绩列表（从下订单会员本人起算，往上直到顶级）,
 * 及该订单所影响到的收益列表（从下订单会员本人起算，往上9级）,
 * 及该订单所影响到的余额列表（从下订单会员本人起算，往上9级）
 * Created by zhangcp on 2016/4/13.17:33
 */
public class OrderAchivementProfitAvailableMoneyBean implements Serializable{
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 业绩列表
     */
    private List<MemberAchivementLog> memberAchivementLogList=new ArrayList<MemberAchivementLog>();
    /**
     * 收益列表
     */
    private List<MemberFreezeBeanExt> profitHisList=new ArrayList<MemberFreezeBeanExt>();
    /**
     * 余额列表
     */
    private List<com.sky.dao.model.MemberProfitBean> availableMoneyHisList=new ArrayList<com.sky.dao.model.MemberProfitBean>();

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<MemberAchivementLog> getMemberAchivementLogList() {
        return memberAchivementLogList;
    }

    public void setMemberAchivementLogList(List<MemberAchivementLog> memberAchivementLogList) {
        this.memberAchivementLogList = memberAchivementLogList;
    }

    public List<MemberFreezeBeanExt> getProfitHisList() {
        return profitHisList;
    }

    public void setProfitHisList(List<MemberFreezeBeanExt> profitHisList) {
        this.profitHisList = profitHisList;
    }

    public List<com.sky.dao.model.MemberProfitBean> getAvailableMoneyHisList() {
        return availableMoneyHisList;
    }

    public void setAvailableMoneyHisList(List<com.sky.dao.model.MemberProfitBean> availableMoneyHisList) {
        this.availableMoneyHisList = availableMoneyHisList;
    }
}
