package com.sky.common.enums;

/**
 * 回写物流状态到订单表
 * Created by Administrator on 2015/10/22.
 */
public enum IsWriteBackEnums {
    NotWrite(0, "未回写"),
    HasWrite(1, "已回写"),
    AgainNotWrite(2, "二次发货不回写");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private IsWriteBackEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static IsWriteBackEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return NotWrite;
            case 1:
                return HasWrite;
            case 2:
                return AgainNotWrite;
            default:
                return NotWrite;
        }
    }
}
