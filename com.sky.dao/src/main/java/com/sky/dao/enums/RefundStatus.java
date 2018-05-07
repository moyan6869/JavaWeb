package com.sky.dao.enums;

/**
 * 退款或退货的最终结果
 * Created by Administrator on 2015/10/22.
 */
public enum RefundStatus {
    Wait(1, "待审核"),
    Processing(2,"处理中"),
    Success(3, "成功"),
    Error(4, "失败");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private RefundStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RefundStatus valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return Wait;
            case 2:
                return Processing;
            case 3:
                return Success;
            case 4:
                return Error;
            default:
                return Error;
        }
    }
}
