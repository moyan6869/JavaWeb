package com.sky.dao.enums;

/**
 * 食品券/补货券流水记录类型 对应Coin_balance表type
 * @author Administrator
 * @date 2018/04/13
 */
public enum CoinBalanceType {

    Unknown(0, "默认"),
    ProfitSend(1, "发放"),
    Pay(2, "支付"),
    TransOut(3, "转出"),
    TransIn(4, "转入"),

    Recharge(5,"充值"),
    SystemImport(6,"导入"),
    Maintenance(7,"后台维护"),
    PayRefund(8,"退单退回"),
    PayErrorBack(9,"支付失败退回"),
    ProfitSendBack(-1, "扣回"),
    ;

    private int code; //错误代码
    private String msg; //错误消息
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private CoinBalanceType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CoinBalanceType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case -1:
                return ProfitSendBack;
            case 1:
                return ProfitSend;
            case 2:
                return Pay;
            case 3:
                return TransOut;
            case 4:
            	return TransIn;
            case 5:
            	return Recharge;
            case 6:
                return SystemImport;
            case 7:
                return Maintenance;
            case 8:
                return PayRefund;
            case 9:
                return PayErrorBack;

            default:
                return Unknown;
        }
    }
}
