package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 描述
 * @Date: 2016/12/19 19:04
 */
public enum LuckDrawStatusEnums {
    Unknow(0, "未中奖"),
    WaitGet(1, "待领取"),
    HasGet(2, "已领取"),
    HasShip(3, "已发货"),
    PastDue(4, "已过期");
    //抽奖状态(0未中奖，1中奖待领取(发放)，2中奖已领取(发放），3实物寄出)
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private LuckDrawStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static LuckDrawStatusEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Unknow;
            case 1:
                return WaitGet;
            case 2:
                return HasGet;
            case 3:
                return HasShip;
            case 4:
                return PastDue;
            default:
                return Unknow;
        }
    }
}
