package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/12/3.
 */
public enum MemberLevel {
    UnKnow(0,"无"),
    Majordomo(1,"总监"),
    SilverCrown(2,"银冠"),
    GoldCrown(3,"金冠"),
    Crown(4,"皇冠"),
    Ambassador(5,"大使"),
    Envoy(6,"特使"),
    FamilyFounder(7,"家族创办人");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberLevel(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberLevel valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return UnKnow;
            case 1:
                return Majordomo;
            case 2:
                return SilverCrown;
            case 3:
                return GoldCrown;
            case 4:
                return Crown;
            case 5:
                return Ambassador;
            case 6:
                return Envoy;
            case 7:
                return FamilyFounder;
            default:
                return UnKnow;
        }
    }
}
