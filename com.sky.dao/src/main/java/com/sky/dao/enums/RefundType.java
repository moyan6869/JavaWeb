package com.sky.dao.enums;

/**
 * 退款或退货
 * Created by Administrator on 2015/10/22.
 */
public enum RefundType {
    Unknow(0, "无退货退款"),
    RefundGoods(1, "申请退货"),
    RefundMoney(2, "申请退款"),
	RefundBalanceGoods(3, "申请退货(余额)"),
	RefundBalanceMoney(4, "申请退款(余额)");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private RefundType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RefundType valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Unknow;
            case 1:
                return RefundGoods;
            case 2:
                return RefundMoney;
            case 3:
                return RefundBalanceGoods;
            case 4:
                return RefundBalanceMoney;
            default:
                return Unknow;
        }
    }
}
