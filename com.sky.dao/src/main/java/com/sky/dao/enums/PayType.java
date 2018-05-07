package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum PayType {
    Unknow(0, "未支付"),
    Wechatpay(1, "微信支付"),
    Alipay(2, "支付宝"),
    offinePay(3, "线下付款"),
    systemPay(4, "系统代付"),
    moneyPay(5, "余额支付"),
    WechatAppPay(6,"微信APP支付"),
    Payment(7,"货款支付"),
    ALLINPAY(8,"通联通支付"),
    RECHARGE_PAY(9,"充值币支付"),
    ChangeCoinPay(11,"换货币支付"),
    CompoundCoinPay(12,"复消币支付"),
    AlipayMix(13,"支付宝混合支付"),
    WechatpayMix(14,"微信混合支付"),
    RBaopay(15,"融宝支付"),
    RBaopayMix(16,"融宝混合支付"),
    FoodPay(17,"食品券支付"),
    SupplyPay(18,"补货券支付");


    private int code; //错误代码
    private String msg; //错误消息



    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private PayType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static PayType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return Wechatpay;
            case 2:
                return Alipay;
            case 3:
                return offinePay;
            case 4:
                return systemPay;
            case 5:
                return moneyPay;
            case 6:
                return WechatAppPay;
            case 7:
                return Payment;
            case 8:
                return ALLINPAY;
            case 9:
                return RECHARGE_PAY;
            case 11:
                return ChangeCoinPay;
            case 12:
                return CompoundCoinPay;
            case 13:
                return AlipayMix;
            case 14:
                return WechatpayMix;
            case 15:
                return RBaopay;
            case 16:
                return RBaopayMix;
            case 17:
                return FoodPay;
            case 18:
                return SupplyPay;
            default:
                return Unknow;
        }
    }
}
