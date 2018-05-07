package com.sky.dao.enums;

/**
 * 豪车基金收益类型
 * Created by zhangcp on 2016/5/10.14:03
 */
public class CarFundProfitType {
    /**
     * 每月豪车奖收入
     */
    public final static int monthCarFundIncome = 1;
    public final static String monthCarFundIncomeName = "收入";
    /**
     * 转出余额
     */
    public final static int turnsOutBalance = 2;
    public final static String turnsOutBalanceName = "转出余额";

    /**
     * 豪车基金手工扣款
     */
    public final static int carFundDeductMoney=3;
    public final static String carFundDeductMoneyName="消费";

    /**
     * 豪车基金手工充值
     */
    public final static int carFundRecharge=4;
    public final static String carFundRechargeName="手工充值";
    public static String getName(int key)
    {
        switch (key) {
            case monthCarFundIncome:
                return monthCarFundIncomeName;
            case turnsOutBalance:
                return turnsOutBalanceName;
            case carFundDeductMoney:
                return carFundDeductMoneyName;
            case carFundRecharge:
                return carFundRechargeName;
            default:
                return "未知收益类型";
        }
    }
}
