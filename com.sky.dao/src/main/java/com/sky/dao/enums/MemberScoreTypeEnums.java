package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 会员积分类型
 * @Date: 2016/12/6 9:29
 */
public enum  MemberScoreTypeEnums {

    Unknow(0, "未知"),
    SignIn(1, "每日签到"),
    LuckDraw(2, "幸运抽奖"),//抽奖扣减
    WinningLuckDraw(3,"大转盘中奖"),
//    注册2次
//    复消（单次购买300及以上）3次
//            报单5次
    Register(4,"注册"),
    BuyAgain(5,"购买奖励"),//复消300以上
    Joining(6,"首单奖励"),
    Upgrade(7,"升级奖励"),
    RegisterNext(8,"推荐奖励")//直推10赠送一次积分

    ;
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberScoreTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberScoreTypeEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return SignIn;
            case 2:
                return LuckDraw;
            case 3:
                return WinningLuckDraw;
            case 4:
                return Register;
            case 5:
                return BuyAgain;
            case 6:
                return Joining;
            case 7:
                return Upgrade;
            case 8:
                return RegisterNext;
            default:
                return Unknow;
        }
    }
}
