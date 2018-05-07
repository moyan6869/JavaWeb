package com.sky.dao.enums;

/**
 * 产品细则类型定义 对应product表的Type字段
 * Created by zhangjie on 2017/09/18.
 */
public enum ProductTypeEnum {

    UnKnow(-1,"未知类型"),
    Retail(0, "零售产品"),
    Gold(1, "金卡套餐"),
    WhiteGold(2, "白金卡套餐"),
    Crown(3,"钻卡套餐"),
    FoodCoin(9,"食品券套餐"),
    Food(10,"生鲜食品"),
    GoldUpWhiteGold(12,"金卡升级白金卡套餐"),
    GoldUpCrown(13,"金卡升级钻卡套餐"),
    WhiteGoldUpCrown(23,"白金卡升级钻卡套餐"),
    GoldenTriangle (999,"金三角套餐"),

    ;

    private int code; //代码
    private String desc; //描述


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private ProductTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static ProductTypeEnum valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Retail;
            case 1:
                return Gold;
            case 2:
                return WhiteGold;
            case 3:
                return Crown;
            case 9:
                return FoodCoin;
            case 10:
                return Food;
            case 12:
                return GoldUpWhiteGold;
            case 13:
                return GoldUpCrown;
            case 23:
                return WhiteGoldUpCrown;
            case 999:
                return GoldenTriangle;
            default:
                return UnKnow;

        }
    }
}
