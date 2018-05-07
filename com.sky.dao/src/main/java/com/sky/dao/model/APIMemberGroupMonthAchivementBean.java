package com.sky.dao.model;

import com.sky.dao.enums.GemType;

/**
 * 团队的用户的加盟业绩和零售业绩
 * Created by Administrator on 2015/11/26.
 */
public class APIMemberGroupMonthAchivementBean {

    private String memberId;
    private String headImage;
    private String phone;
    private String nickName;
    private String userName;
    private Integer memberType=0;
    private String memberTypeStr;
    private Integer month;
    private long SaleMeMoney;//自己的业绩
    private long retailMeMoney;
    private long saleAchivementMonthMoney;//加盟业绩
    private long retailAchivementMonthMoney;  //当月总业绩
    private long me_compound_achivement;  //当月个人复销币转结业绩
    private long sum_compound_achivement;  //当月团队复销币转结业绩
    private long ext_money;  //小部门业绩

    private Integer leader_level;//奖衔

    public long getMe_compound_achivement() {
        return me_compound_achivement;
    }

    public Integer getLeader_level() {
        return leader_level;
    }

    public void setLeader_level(Integer leader_level) {
        this.leader_level = leader_level;
    }

    public void setMe_compound_achivement(long me_compound_achivement) {
        this.me_compound_achivement = me_compound_achivement;

    }

    public long getExt_money() {
        return ext_money;
    }

    public long getSum_compound_achivement() {
        return sum_compound_achivement;
    }

    public void setSum_compound_achivement(long sum_compound_achivement) {
        this.sum_compound_achivement = sum_compound_achivement;
    }

    public void setExt_money(long ext_money) {
        this.ext_money = ext_money;
    }




    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeStr() {
        return GemType.getGemTypeName(memberType);
    }

    public void setMemberTypeStr(String memberTypeStr) {
        this.memberTypeStr = memberTypeStr;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public long getSaleMeMoney() {
        return SaleMeMoney;
    }

    public void setSaleMeMoney(long saleMeMoney) {
        SaleMeMoney = saleMeMoney;
    }

    public long getRetailMeMoney() {
        return retailMeMoney;
    }

    public void setRetailMeMoney(long retailMeMoney) {
        this.retailMeMoney = retailMeMoney;
    }

    public long getSaleAchivementMonthMoney() {
        return saleAchivementMonthMoney;
    }

    public void setSaleAchivementMonthMoney(long saleAchivementMonthMoney) {
        this.saleAchivementMonthMoney = saleAchivementMonthMoney;
    }

    public long getRetailAchivementMonthMoney() {
        return retailAchivementMonthMoney;
    }

    public void setRetailAchivementMonthMoney(long retailAchivementMonthMoney) {
        this.retailAchivementMonthMoney = retailAchivementMonthMoney;
    }
}
