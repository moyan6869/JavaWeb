package com.sky.web.model;

import com.sky.dao.model.MemberMoneyTotalBean;

import java.io.Serializable;

/**
 * dect:用于结算平台,会员收益显示
 * Created by zhangcp on 2016/3/21.16:37
 */
public class MemberProfit implements Serializable {
    /**
     * 会员
     */
    private Member member;



    /**
     * 会员总收益
     */
    private MemberMoneyTotalBean memberMoneyTotalBean;
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberMoneyTotalBean getMemberMoneyTotalBean() {
        return memberMoneyTotalBean;
    }

    public void setMemberMoneyTotalBean(MemberMoneyTotalBean memberMoneyTotalBean) {
        this.memberMoneyTotalBean = memberMoneyTotalBean;
    }




}
