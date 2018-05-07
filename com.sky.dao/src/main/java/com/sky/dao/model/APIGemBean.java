package com.sky.dao.model;

/**
 * Created by Administrator on 2015/11/30.
 */
public class APIGemBean {

    /**
     * 宝石数量
     */
    private int gem1;
    /**
     * 钻石数量
     */
    private int gem2;
    /**
     * 金钻数量
     */
    private int gem3;

    /**
     * 会员活跃期截至日期
     */
    private String memberActiveDate;
    
    private String imageUrl;

    private boolean teamMemberIsActive;//团队当月是否有活跃点

    /**
     * 成为会员时间
     */
    private String beMemberDate;

    private long remainUpMoney;

    /**
     * 今日新增收益
     */
    private long currentDayProfit;

    public long getCurrentDayProfit() {
        return currentDayProfit;
    }

    public void setCurrentDayProfit(long currentDayProfit) {
        this.currentDayProfit = currentDayProfit;
    }

    public String getBeMemberDate() {
        return beMemberDate;
    }

    public void setBeMemberDate(String beMemberDate) {
        this.beMemberDate = beMemberDate;
    }

    public int getGem1() {
        return gem1;
    }

    public void setGem1(int gem1) {
        this.gem1 = gem1;
    }

    public int getGem2() {
        return gem2;
    }

    public void setGem2(int gem2) {
        this.gem2 = gem2;
    }

    public int getGem3() {
        return gem3;
    }

    public void setGem3(int gem3) {
		this.gem3 = gem3;
	}

    public long getRemainUpMoney() {
        return remainUpMoney;
    }

    public void setRemainUpMoney(long remainUpMoney) {
        this.remainUpMoney = remainUpMoney;
    }

    public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

    public String getMemberActiveDate() {
        return memberActiveDate;
    }

    public void setMemberActiveDate(String memberActiveDate) {
        this.memberActiveDate = memberActiveDate;
    }

    public boolean isTeamMemberIsActive() {
        return teamMemberIsActive;
    }

    public void setTeamMemberIsActive(boolean teamMemberIsActive) {
        this.teamMemberIsActive = teamMemberIsActive;
    }
}
