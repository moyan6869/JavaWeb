package com.sky.dao.vo;



import com.sky.dao.model.MemberAchivementLog;
import com.sky.dao.model.MemberFreezeBeanExt;
import com.sky.dao.model.MemberProfitBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 封装某个订单号(orderCode)所影响到的当个会员的业绩列表,
 * 及该订单所影响到的当个会员的收益列表,
 * 及该订单所影响到的当个会员的余额列表
 * Created by zhangcp on 2016/4/14.14:37
 */
public class MemberOrderAchivementProfitAvailableMoneyBean implements Serializable {
    /**
     * 会员
     */
    private MemberBean memberBean;
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
    private List<com.sky.dao.model.MemberProfitBean> availableMoneyHisList=new ArrayList<MemberProfitBean>();

    public MemberBean getMemberBean() {
        return memberBean;
    }

    public void setMemberBean(MemberBean memberBean) {
        this.memberBean = memberBean;
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

    public List<MemberProfitBean> getAvailableMoneyHisList() {
        return availableMoneyHisList;
    }

    public void setAvailableMoneyHisList(List<MemberProfitBean> availableMoneyHisList) {
        this.availableMoneyHisList = availableMoneyHisList;
    }
}
