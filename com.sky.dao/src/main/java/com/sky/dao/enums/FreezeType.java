package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum FreezeType {
    Unknow(0, "默认没冻结"),
    FreezeMember(1, "您的账号异常，原因："),
    FreezeProfitAndMoney(2, "收益余额冻结，原因："),
    FreezeProfit(3,"收益冻结，原因："),
    FreezeMoney(4,"余额冻结：原因：");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private FreezeType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static FreezeType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return FreezeMember;
            case 2:
                return FreezeProfitAndMoney;
            case 3:
                return FreezeProfit;
            case 4:
                return FreezeMoney;
            default:
                return Unknow;
        }
    }
}
