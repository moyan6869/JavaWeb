package com.sky.dao.enums;

/**
 * 退款或退货
 * Created by Administrator on 2015/10/22.
 */
public enum RefundCheck {
    Unknow(0, "正常"),
    ExceedTime(1, "订单已经超过：30天"),
    ExceedMoney(2, "订单金额已经超出9900，99000");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private RefundCheck(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RefundCheck valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Unknow;
            case 1:
                return ExceedTime;
            case 2:
                return ExceedMoney;
            default:
                return Unknow;
        }
    }
}
