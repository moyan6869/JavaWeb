package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum OrderStatus {
    HasClose(0, "已关闭"),
    WaitPay(1, "待付款"),
    WaitShip(2, "待发货"),
    HasShip(3, "已发货"),
    HasReceived(4, "已收货"),
    ReturnMoneying(5, "处理中"),//退款中
    ReturnGooding(6, "处理中"),//退货中
    ReturnMoneyClose(7, "退款完成"),
    ReturnGoodClose(8, "退款完成"),//退货完成
    ErrorOrder(9, "异常订单");


    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private OrderStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static OrderStatus valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return HasClose;
            case 1:
                return WaitPay;
            case 2:
                return WaitShip;
            case 3:
                return HasShip;
            case 4:
                return HasReceived;
            case 5:
                return ReturnMoneying;
            case 6:
                return ReturnGooding;
            case 7:
                return ReturnMoneyClose;
            case 8:
                return ReturnGoodClose;
            case 9:
                return ErrorOrder;
            default:
                return HasClose;
        }
    }
}
