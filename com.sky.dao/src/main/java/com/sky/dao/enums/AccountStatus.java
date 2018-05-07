package com.sky.dao.enums;

/**
 * Created by wangyun on 2016/1/15.
 */
public enum AccountStatus {
    WaitCheck(0, "待审核"),
    CheckSuccess(1, "审核成功"),
    CheckFail(2, "审核失败");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private AccountStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AccountStatus valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return WaitCheck;
            case 1:
                return CheckSuccess;
            case 2:
                return CheckFail;
            default:
                return WaitCheck;
        }
    }
}
