package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum SkyMemberType {
    NotMember(0, "非会员"),
    Gem(1, "金卡"),
    Diamond(2, "白金卡"),
    GoldenDiamond(3, "钻卡");
//    cloud(100,"云客"),
//    business(105,"云商");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private SkyMemberType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SkyMemberType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return Gem;
            case 2:
                return Diamond;
            case 3:
                return GoldenDiamond;
//            case 100:
//                return cloud;
//            case 105:
//                return business;
            default:
                return NotMember;
        }
    }
}
