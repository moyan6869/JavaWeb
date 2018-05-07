package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 冠级
 * @Date: 2017/2/21 15:08
 */
public enum CrownLevelEnums {
    UnKnow(0,"无"),
    Majordomo(1,"总监"),
    SilverCrown(2,"高级总监"), //银冠
    GoldCrown(3,"资深总监"),//金冠
    Crown(4,"执行总裁"),//皇冠
    Ambassador(5,"行政总裁"),//大使
    Envoy(6,"董事总裁"),//特使
    FamilyFounder(7,"联合董事");//家族创办人



    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private CrownLevelEnums(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public static CrownLevelEnums valueOf(Integer code){
        switch (code){
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
