package com.sky.common.enums;

/**
 * 快递状态
 * Created by Administrator on 2015/10/22.
 */
public enum ExpressIdEnums {
    NoExpress(0, "未推送"),
    YTOExpress(1, "圆通快递"),
    SaiEnExpress(2, "赛恩快递"),
    ERPExpress(3, "ERP"),
    YONGJUNExpress(4, "永骏快递"),
    YTOExpressFail(-1, "推送圆通失败"),
    SaiEnExpressFail(-2, "推送赛恩失败"),
    ERPExpressFail(-3, "推送ERP失败"),
    YONGJUNExpressFail(-4, "推送永骏失败");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private ExpressIdEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ExpressIdEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return NoExpress;
            case 1:
                return YTOExpress;
            case 2:
                return SaiEnExpress;
            case 3:
                return ERPExpress;
            case 4:
                return YONGJUNExpress;
            case -1:
                return YTOExpressFail;
            case -2:
                return SaiEnExpressFail;
            case -3:
                return ERPExpressFail;
            case -4:
                return YONGJUNExpressFail;
            default:
                return NoExpress;
        }
    }
}
