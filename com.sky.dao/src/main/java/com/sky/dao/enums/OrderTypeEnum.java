package com.sky.dao.enums;

/**
 * Created by xuyuyong on 2017/7/26.
 * @author xuyuyong
 */
public enum OrderTypeEnum {
    RETAIL(0, "零售单"),
    BARTER(-1, "换货单"),
    DOUBLE_PIN(2, "升级单"),
    UP_COVER(3, "覆盖升级"),
    ACHIVEMENTING(4, "业绩累积"),

    FOOD(10, "生鲜单"),
    SUPPLY(11, "补货单"),

    GOLDEN_TRIANGLE(999, "金三角套餐"),
    JOIN_IN(1, "加盟单");

    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误消息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private OrderTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 手写的从int到enum的转换函数
     * @param value
     * @return
     */
    public static OrderTypeEnum valueOf(int value) {
        switch (value) {
            case 0:
                return RETAIL;
            case -1:
                return BARTER;
            case 2:
                return DOUBLE_PIN;
            case 1:
                return JOIN_IN;
            case 3:
                return UP_COVER;
            case 4:
                return ACHIVEMENTING;
            case 10:
                return FOOD;
            case 11:
                return SUPPLY;
            case 999:
                return GOLDEN_TRIANGLE;
            default:
                return RETAIL;
        }
    }
}
