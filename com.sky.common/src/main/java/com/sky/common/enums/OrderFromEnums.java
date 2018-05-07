package com.sky.common.enums;

/**
 * 订单平台
 * Created by Administrator on 2015/10/22.
 */
public enum OrderFromEnums {
    YUNWS(1, "云微商"),
    Retail(2, "零售");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private OrderFromEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static OrderFromEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return YUNWS;
            case 2:
                return Retail;
            default:
                return YUNWS;
        }
    }
}
