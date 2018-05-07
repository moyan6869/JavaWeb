package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum MemberBalanceType {
    Unknow(0, "默认"),
    GetCash(1, "提现"),
    OutPay(2, "余额转出"),
    ToPay(3, "余额转入"),
    OutPayBack(4, "余额转出退回"),
	oldSysPay(5,"原系统余额导入"),
    prestorePay(6,"预存款充值"),
    DisOutPrstoreMoeny(7,"预存置出"),
    DisInAvailableMoney(8,"余额置入"),
    changeCoinImport(10,"原系统换货币导入"),
    changeCoinSend(11,"换货币发放"),
    compoundCoinSend(12,"复销币发放"),
    DisOutCompound(13,"复销币置出"),
    DisInChange(14,"换货币置入"),
    compoundTransformAvailableMoney(15,"复销币转奖金币"),
    useMoneyOutYun(16,"可提现余额转出至云Mall");

    private int code; //错误代码
    private String msg; //错误消息
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberBalanceType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberBalanceType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return GetCash;
            case 2:
                return OutPay;
            case 3:
                return ToPay;
            case 4:
            	return OutPayBack;
            case 5:
            	return oldSysPay;
            case 6:
                return prestorePay;
            case 7:
                return DisOutPrstoreMoeny;
            case 8:
                return DisInAvailableMoney;
            case 10:
                return changeCoinImport;
            case 11:
                return changeCoinSend;
            case 12:
                return compoundCoinSend;
            case 13:
                return DisOutCompound;
            case 14:
                return DisInChange;
            case 15:
                return compoundTransformAvailableMoney;
            case 16:
                return useMoneyOutYun;
            default:
                return Unknow;
        }
    }
}
