package com.sky.common.enums;

/**
 * 省份
 * Created by Administrator on 2015/10/22.
 */
public enum ProviceEnums {
    Provice_0(0, ""),
    Provice_1(1, "北京市"),
    Provice_2(2, "天津市"),
    Provice_3(3, "河北省"),
    Provice_4(4, "山西省"),
    Provice_5(5, "内蒙古自治区"),
    Provice_6(6, "辽宁省"),
    Provice_7(7, "吉林省"),
    Provice_8(8, "黑龙江省"),
    Provice_9(9, "上海市"),
    Provice_10(10, "江苏省"),
    Provice_11(11, "浙江省"),
    Provice_12(12, "安徽省"),
    Provice_13(13, "福建省"),
    Provice_14(14, "江西省"),
    Provice_15(15, "山东省"),
    Provice_16(16, "河南省"),
    Provice_17(17, "湖北省"),
    Provice_18(18, "湖南省"),
    Provice_19(19, "广东省"),
    Provice_20(20, "广西壮族自治区"),
    Provice_21(21, "海南省"),
    Provice_22(22, "重庆市"),
    Provice_23(23, "四川省"),
    Provice_24(24, "贵州省"),
    Provice_25(25, "云南省"),
    Provice_26(26, "西藏自治区"),
    Provice_27(27, "陕西省"),
    Provice_28(28, "甘肃省"),
    Provice_29(29, "青海省"),
    Provice_30(30, "宁夏回族自治区"),
    Provice_31(31, "新疆维吾尔自治区"),
    Provice_32(32, "台湾省"),
    Provice_33(33, "香港特别行政区"),
    Provice_34(34, "澳门特别行政区"),
    Provice_35(35, "海外");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ProviceEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ProviceEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Provice_0;
            case 1:
                return Provice_1;
            case 2:
                return Provice_2;
            case 3:
                return Provice_3;
            case 4:
                return Provice_4;
            case 5:
                return Provice_5;
            case 6:
                return Provice_6;
            case 7:
                return Provice_7;
            case 8:
                return Provice_8;
            case 9:
                return Provice_9;
            case 10:
                return Provice_10;
            case 11:
                return Provice_11;
            case 12:
                return Provice_12;
            case 13:
                return Provice_13;
            case 14:
                return Provice_14;
            case 15:
                return Provice_15;
            case 16:
                return Provice_16;
            case 17:
                return Provice_17;
            case 18:
                return Provice_18;
            case 19:
                return Provice_19;
            case 20:
                return Provice_20;
            case 21:
                return Provice_21;
            case 22:
                return Provice_22;
            case 23:
                return Provice_23;
            case 24:
                return Provice_24;
            case 25:
                return Provice_25;
            case 26:
                return Provice_26;
            case 27:
                return Provice_27;
            case 28:
                return Provice_28;
            case 29:
                return Provice_29;
            case 30:
                return Provice_30;
            case 31:
                return Provice_31;
            case 32:
                return Provice_32;
            case 33:
                return Provice_33;
            case 34:
                return Provice_34;
            case 35:
                return Provice_35;
            default:
                return Provice_0;
        }
    }
}
