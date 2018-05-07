package com.sky.common.enums;

/**
 * 推送状态
 * Created by Administrator on 2015/10/22.
 */
public enum PushStatusEnums {
    UnKnow(0, "未知"),
    Success(1, "成功"),
    Fail(2, "失败");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private PushStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static PushStatusEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return UnKnow;
            case 1:
                return Success;
            case 2:
                return Fail;
            default:
                return UnKnow;
        }
    }
}
