package com.sky.dao.model;

import com.sky.dao.enums.CrownLevelEnums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/26.
 */
public class APIUserDataStatBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 3167983375191469069L;


    private Integer memberType;
    private String memberTypeStr;
    private Integer incId;
    private Date createDate;
    private String headImage;
    private String phone;
    private String identityCard;
    private String userName;
    private long readyMoney; //可提现余额
    private Integer leader_level;//奖衔
    private String leaderLevelStr;

    private long me_compound_achivement;  //当月个人复销币转结业绩
    private long sum_compound_achivement;  //当月团队复销币转结业绩
    private long ext_money;  //小部门业绩
    private long retailMeMoney;
    private Integer shopType;
    private String shopTypeStr;

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

    public long getExt_money() {
        return ext_money;
    }

    public String getShopTypeStr() {
        return shopTypeStr;
    }

    public void setShopTypeStr(String shopTypeStr) {
        this.shopTypeStr = shopTypeStr;
    }

    public void setExt_money(long ext_money) {
        this.ext_money = ext_money;
    }

    public long getRetailMeMoney() {
        return retailMeMoney;
    }

    public void setRetailMeMoney(long retailMeMoney) {
        this.retailMeMoney = retailMeMoney;
    }

    /**
     * 前一日的日结总收益
     */
    private long profitDayMoney;
    /**
     * 前一月的月结总收益
     */
    private long profitMonthMoney;

    public long getProfitDayMoney() {
        return profitDayMoney;
    }

    public String getLeaderLevelStr() {
        return leaderLevelStr;
    }

    public void setLeaderLevelStr(String leaderLevelStr) {
        this.leaderLevelStr = leaderLevelStr;
    }

    public void setProfitDayMoney(long profitDayMoney) {
        this.profitDayMoney = profitDayMoney;
    }

    public long getProfitMonthMoney() {
        return profitMonthMoney;
    }

    public void setProfitMonthMoney(long profitMonthMoney) {
        this.profitMonthMoney = profitMonthMoney;
    }

    public long getReadyMoney() {
        return readyMoney;
    }

    public Integer getLeader_level() {
        return leader_level;
    }

    public void setLeader_level(Integer leader_level) {
        this.leader_level = leader_level;
    }

    public void setReadyMoney(long readyMoney) {
        this.readyMoney = readyMoney;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private String nickName;


    public String getMemberTypeStr() {
        return memberTypeStr;
    }

    public void setMemberTypeStr(String memberTypeStr) {
        this.memberTypeStr = memberTypeStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getIncId() {
        return incId;
    }

    public void setIncId(Integer incId) {
        this.incId = incId;
    }

    private String activeTime;

    public String getActiveTime() {

        return activeTime;
    }


    public void setActiveTime(Date  activeTimes) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        activeTime = format.format(activeTimes);
    }



    private boolean isActiveOrNot;//是否在活跃期内 true表示在活跃期内

    public boolean isActiveOrNot() {
        return isActiveOrNot;
    }

    public void setActiveOrNot(boolean activeOrNot) {
        isActiveOrNot = activeOrNot;
    }

    /**
     * 宝石、钻石、金钻的数量
     */
    private APIGemBean gem;
    /**
     * 总收益
     */
    private long profitSumMoney;
    /**
     * 可提现余额
     */
    private long availableMoney;

    /*可用预存款*/
    private long prestored;

    /**
     * 冻结金额
     */
    private long freezeSumMoney;

    /**
     * 提现总金额
     */
    private long dealSumMoney;
    /**
     * 复消币
     */

    private long compoundCoin;
    /**
     * 换货币
     */
    private long changeCoin;

    /*
    * 距离更高一级级别还差得钱数
    * */
    private long ShortMoney;

    public long getShortMoney() {
        return ShortMoney;
    }

    public void setShortMoney(long shortMoney) {
        ShortMoney = shortMoney;
    }

    /**
     * 本月团队业绩
     */
    private long groupUserCurrentMonthAchivement;

    public long getCurrentMonthMeMoney() {
        return currentMonthMeMoney;
    }

    public void setCurrentMonthMeMoney(long currentMonthMeMoney) {
        this.currentMonthMeMoney = currentMonthMeMoney;
    }

    /*
        *本月消费金额
        * */
    private long currentMonthMeMoney;
    /**
     * 我的客户
     */
    private int groupUserCount;

    //提示信息所用的list
    private List msgList;

    public List getMsgList() {
        return msgList;
    }

    public void setMsgList(List msgList) {
        this.msgList = msgList;
    }

    private int memberLevel;//等级
    /** 会员当前级别    */
    private String memberCurrentLevel;
    private String memberCurrentLevelImage;

    private int  crownLevel;//冠级
    private String crownLevelStr;
    private String nextCrownLevelStr;

    /**   [修改成表达合伙人星级数量 2016-10-06]     */
    private int partnerNum;

    public long getCompoundCoin() {
        return compoundCoin;
    }

    public void setCompoundCoin(long compoundCoin) {
        this.compoundCoin = compoundCoin;
    }

    public long getChangeCoin() {
        return changeCoin;
    }

    public void setChangeCoin(long changeCoin) {
        this.changeCoin = changeCoin;
    }

    public String getCrownLevelStr() {
        return CrownLevelEnums.valueOf(crownLevel).getMsg();
    }

    public void setCrownLevelStr(String crownLevelStr) {
        this.crownLevelStr = crownLevelStr;
    }

    public String getNextCrownLevelStr() {
        return nextCrownLevelStr;
    }

    public void setNextCrownLevelStr(String nextCrownLevelStr) {
        this.nextCrownLevelStr = nextCrownLevelStr;
    }

    public int getCrownLevel() {
        return crownLevel;
    }

    public void setCrownLevel(int crownLevel) {
        this.crownLevel = crownLevel;
    }

    public long getPrestored() {
        return prestored;
    }

    public void setPrestored(long prestored) {
        this.prestored = prestored;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }


    //月销售业绩
    private long saleAchivementMonthMoney;

    public long getSaleAchivementMonthMoney() {
        return saleAchivementMonthMoney;
    }

    public void setSaleAchivementMonthMoney(long saleAchivementMonthMoney) {
        this.saleAchivementMonthMoney = saleAchivementMonthMoney;
    }



    /**
     * 豪车基金
     */
    private long carFundSumMoney;

    /**
     * 旅游基金
     */
    private long tripFundSumMoney;

    /*成长基金*/
    private long upFundSumMoney=0;

    private long trsinSumMoney;

    //消息提示
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //左区业绩
    private long leftAchivement;
    //右区业绩
    private long rightAchivement;

    public long getLeftAchivement() {
        return leftAchivement;
    }
    //零售业绩
    public long sumMoney;

    //是否已经签到
    public Integer isSignIn=0;

    public Integer getIsSignIn() {
        return isSignIn;
    }

    public void setIsSignIn(Integer isSignIn) {
        this.isSignIn = isSignIn;
    }

    public long getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(long sumMoney) {
        this.sumMoney = sumMoney;
    }


    public void setLeftAchivement(long leftAchivement) {
        this.leftAchivement = leftAchivement;
    }

    public long getRightAchivement() {
        return rightAchivement;
    }

    public void setRightAchivement(long rightAchivement) {
        this.rightAchivement = rightAchivement;
    }

    public long getUpFundSumMoney() {
        return upFundSumMoney;
    }

    public void setUpFundSumMoney(long upFundSumMoney) {
        this.upFundSumMoney = upFundSumMoney;
    }

    public long getTrsoutSumMoney() {
        return trsoutSumMoney;
    }

    public void setTrsoutSumMoney(long trsoutSumMoney) {
        this.trsoutSumMoney = trsoutSumMoney;
    }

    public long getTrsinSumMoney() {
        return trsinSumMoney;
    }

    public void setTrsinSumMoney(long trsinSumMoney) {
        this.trsinSumMoney = trsinSumMoney;
    }

    private long trsoutSumMoney;

    public APIGemBean getGem() {
        return gem;
    }

    public void setGem(APIGemBean gem) {
        this.gem = gem;
    }

    public long getProfitSumMoney() {
        return profitSumMoney;
    }

    public void setProfitSumMoney(long profitSumMoney) {
        this.profitSumMoney = profitSumMoney;
    }

    public long getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(long availableMoney) {
        this.availableMoney = availableMoney;
    }

    public long getFreezeSumMoney() {
        return freezeSumMoney;
    }

    public void setFreezeSumMoney(long freezeSumMoney) {
        this.freezeSumMoney = freezeSumMoney;
    }

    public long getDealSumMoney() {
        return dealSumMoney;
    }

    public void setDealSumMoney(long dealSumMoney) {
        this.dealSumMoney = dealSumMoney;
    }

    public long getGroupUserCurrentMonthAchivement() {
        return groupUserCurrentMonthAchivement;
    }

    public void setGroupUserCurrentMonthAchivement(long groupUserCurrentMonthAchivement) {
        this.groupUserCurrentMonthAchivement = groupUserCurrentMonthAchivement;
    }

    public int getGroupUserCount() {
        return groupUserCount;
    }

    public void setGroupUserCount(int groupUserCount) {
        this.groupUserCount = groupUserCount;
    }


    public String getMemberCurrentLevel() {
        return memberCurrentLevel;
    }

    public void setMemberCurrentLevel(String memberCurrentLevel) {
        this.memberCurrentLevel = memberCurrentLevel;
    }

    public String getMemberCurrentLevelImage() {
        return memberCurrentLevelImage;
    }

    public void setMemberCurrentLevelImage(String memberCurrentLevelImage) {
        this.memberCurrentLevelImage = memberCurrentLevelImage;
    }

    public int getPartnerNum() {
        return partnerNum;
    }

    public void setPartnerNum(int partnerNum) {
        this.partnerNum = partnerNum;
    }

    public Long getCarFundSumMoney() {
        return carFundSumMoney;
    }

    public void setCarFundSumMoney(Long carFundSumMoney) {
        this.carFundSumMoney = carFundSumMoney;
    }

    public Long getTripFundSumMoney() {
        return tripFundSumMoney;
    }

    public void setTripFundSumMoney(Long tripFundSumMoney) {
        this.tripFundSumMoney = tripFundSumMoney;
    }

    @Override
    public String toString() {
        return "CrownLevelStr:"+this.getCrownLevelStr()+":CrownLevel:"+this.getCrownLevel()+";MemberCurrentLevelImage:"+this.getMemberCurrentLevelImage()+":nextCrownLevelStr:"+this.getNextCrownLevelStr();
    }
}
