package com.sky.common.enums;

/**
 * 快递状态
 * Created by Administrator on 2015/10/22.
 */
public enum ExpressTypeEnums {
    Packaging(0, "打包"),
    NoticeExpress(1, "通知快递"),
    LanJian(2,"快递已揽收"),
    YunShuing(3,"运输途中"),
    Arrive(4,"到达目的地"),
    Delivery(5,"正在派件"),
    Received(6, "已签收"),
    REJ(7,"收件人拒收");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ExpressTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ExpressTypeEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Packaging;
            case 1:
                return NoticeExpress;
            case 2:
                return LanJian;
            case 3:
                return YunShuing;
            case 4:
                return Arrive;
            case 5:
                return Delivery;
            case 6:
                return Received;
            case 7:
                return REJ;
            default:
                return Packaging;
        }
    }
}
