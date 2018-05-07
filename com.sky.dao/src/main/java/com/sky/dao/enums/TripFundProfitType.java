package com.sky.dao.enums;

/**
 * 旅游基金收益类型
 * Created by zhangcp on 2016/5/10.14:04
 */
public class TripFundProfitType {
    /**
     * 每月豪车奖收入
     */
    public final static int monthTripFundIncome = 1;
    public final static String monthTripFundIncomeName = "收入";
    /**
     * 转出余额
     */
    public final static int turnsOutBalance = 2;
    public final static String turnsOutBalanceName = "转出余额";

    /**
     * 旅游基金手工扣款
     */
    public final static int tripFundDeductMoney=3;
    public final static String tripFundDeductMoneyName="消费";

    /**
     * 旅游基金手工充值
     */
    public final static int tripFundRecharge=4;
    public final static String tripFundRechargeName="手工充值";
    public static String getName(int key)
    {
        switch (key) {
            case monthTripFundIncome:
                return monthTripFundIncomeName;
            case turnsOutBalance:
                return turnsOutBalanceName;
            case tripFundDeductMoney:
                return tripFundDeductMoneyName;
            case tripFundRecharge:
                return tripFundRechargeName;
            default:
                return "未知收益类型";
        }
    }
}
