package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: SIBU Kanger
 * @Description: 会员消息类型
 * @Date: 2016/9/28 17:01
 */
public enum MemberMessageTypeEnums {
    //0、系统消息；1、注册消息；10、报单消息；20、安置消息；30、升级消息；40、订单消息；50、收益消息；60、冻结消息;70、转账消息；80、广告消息
    SysMsg(0, "系统消息"),
    RegistMsg(1,"注册消息"),
    RegistNextMsg(2,"市场注册消息"),
    JoinMsg(10,"报单消息"),
    JoinNextMsg(11,"市场报单消息"),
    PlaceMsg(20,"安置消息"),
    PlaceLeftMsg(21,"左区安置消息"),
    PlaceRightMsg(22,"右区安置消息"),
    UpGradeMsg(30,"升级消息"),
    UpGradeNextMsg(31,"市场升级消息"),
    OrderMsg(40,"订单消息"),
    OrderBalancePayMsg(41,"余额支付消息"),
    OrderWeChatPayMsg(42,"微信支付消息"),
    OrderAliPayMag(43,"支付宝支付消息"),
    ShipOrderMsg(44,"发货消息"),
    ReceiveOrderMsg(45,"确认收货消息"),
    AppRefundMonery(46,"申请退款"),
    AppRefundGood(47,"申请退货"),
    OrderOffinePay(48, "线下付款"),
    OrderSystemPay(49, "系统代付"),
    ProfitMsg(50,"收益消息"),
    RefundMoneySuccess(51,"退款成功"),
    FreezeMsg(60,"冻结消息"),
    FreezeAccountMsg(61,"账户冻结"),
    FreezeProfitMsg(62,"收益冻结"),
    FreezeMoneyMsg(63,"余额冻结"),
    TrsOutMsg(70,"转账消息"),
    LuckDrawMsg(71,"中奖消息"),
    ADMsg(80,"广告消息");
    private int code; //错误代码
    private String msg; //错误消息
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    private MemberMessageTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static MemberMessageTypeEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return RegistMsg;
            case 2:
                return RegistNextMsg;
            case 10:
                return JoinMsg;
            case 11:
                return JoinNextMsg;
            case 20:
                return PlaceMsg;
            case 21:
                return PlaceLeftMsg;
            case 22:
                return PlaceRightMsg;
            case 30:
                return UpGradeMsg;
            case 31:
                return UpGradeNextMsg;
            case 40:
                return OrderMsg;
            case 41:
                return OrderBalancePayMsg;
            case 42:
                return OrderWeChatPayMsg;
            case 43:
                return OrderAliPayMag;
            case 44:
                return ShipOrderMsg;
            case 45:
                return ReceiveOrderMsg;
            case 46:
                return AppRefundMonery;
            case 47:
                return AppRefundGood;
            case 48:
                return OrderOffinePay;
            case 49:
                return OrderSystemPay;
            case 50:
                return ProfitMsg;
            case 51:
                return RefundMoneySuccess;
            case 60:
                return FreezeMsg;
            case 61:
                return FreezeAccountMsg;
            case 62:
                return FreezeAccountMsg;
            case 63:
                return FreezeMoneyMsg;
            case 70:
                return TrsOutMsg;
            case 71:
                return LuckDrawMsg;
            case 80:
                return ADMsg;
            default:
                return SysMsg;
        }
    }
}
