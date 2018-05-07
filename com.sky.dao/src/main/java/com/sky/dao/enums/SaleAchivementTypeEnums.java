package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 销售业绩类型
 * @Date: 2016/12/21 15:43
 */
public enum SaleAchivementTypeEnums {//默认0 下级订单，1我的订单,2下级退款订单,3我的退款订单
    NextOrder(0, "市场订单"),
    MyOrder(1, "我的订单"),
    RefundNextOrder(2, "市场退款订单"),
    RefundMyOrder(3, "我的退款订单");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private SaleAchivementTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SaleAchivementTypeEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return NextOrder;
            case 1:
                return MyOrder;
            case 2:
                return RefundNextOrder;
            case 3:
                return RefundMyOrder;
            default:
                return NextOrder;
        }
    }
}
