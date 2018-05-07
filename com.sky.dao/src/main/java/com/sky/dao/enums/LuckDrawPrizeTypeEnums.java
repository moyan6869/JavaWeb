package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 描述
 * @Date: 2016/12/21 15:43
 */
public enum  LuckDrawPrizeTypeEnums {//0未中奖，1虚拟奖品，2，实物奖品
    Unknow(0, "空奖品"),
    Virtual(1, "虚拟物品"),
    RealObject(2, "实物奖品");
    //抽奖状态(0未中奖，1中奖待领取(发放)，2中奖已领取(发放），3实物寄出)
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private LuckDrawPrizeTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static LuckDrawPrizeTypeEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Unknow;
            case 1:
                return Virtual;
            case 2:
                return RealObject;
            default:
                return Unknow;
        }
    }
}
