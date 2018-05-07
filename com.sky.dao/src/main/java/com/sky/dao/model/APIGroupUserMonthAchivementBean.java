package com.sky.dao.model;

import com.sky.dao.enums.GemType;

/**
 * 团队的用户的月业绩
 * Created by Administrator on 2015/11/26.
 */
public class APIGroupUserMonthAchivementBean {

    private String memberId;
    private String memberHeadImage;
    private String memberPhone;
    private String memberNickName;
    private String memberUserName;
    private Integer memberType=0;
    private String memberTypeStr;
    private String placeMemberId;
    private Integer month;
    private Long monthSumMoney;
    private APIGemBean gem;

    private Integer leader_level;//奖衔
    private String leaderLevelStr;

    private long me_compound_achivement;  //当月个人复销币转结业绩
    private long sum_compound_achivement;  //当月团队复销币转结业绩
    private long ext_money;  //小部门业绩
    private long retailMeMoney;

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

    public String getPlaceMemberId() {
        return placeMemberId;
    }

    public void setPlaceMemberId(String placeMemberId) {
        this.placeMemberId = placeMemberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberHeadImage() {
        return memberHeadImage;
    }

    public void setMemberHeadImage(String memberHeadImage) {
        this.memberHeadImage = memberHeadImage;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getMonthSumMoney() {
        return monthSumMoney;
    }

    public void setMonthSumMoney(Long monthSumMoney) {
        this.monthSumMoney = monthSumMoney;
    }

    public APIGemBean getGem() {
        return gem;
    }

    public void setGem(APIGemBean gem) {
        this.gem = gem;
    }

	public String getMemberUserName() {
		return memberUserName;
	}

	public void setMemberUserName(String memberUserName) {
		this.memberUserName = memberUserName;
	}
}
