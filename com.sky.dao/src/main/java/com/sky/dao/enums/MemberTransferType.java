package com.sky.dao.enums;

import java.lang.ref.PhantomReference;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/22
 * Description:转账业务表类型（失败类型）
 */
public enum MemberTransferType {
    Unknow(0, "未知"),
    TRANSFER_IN(4, "转入"),
    TRANSFER_OUT(5, "转出"),
    PAY_MENT(6, "支出"),
    PAY_MENT_FOR_PROXY(7, "代报单支出"),

    RedEnvelope_TRANSFER_IN(8, "红包转入"),
    RedEnvelope_TRANSFER_OUT(9, "红包转出"),
    PreStored_TRANSFER_IN(10,"货款转入"),
    PreStored_TRANSFER_OUT(11, "货款转出")  ,
    PreStored_Pay(12, "货款充值"),
    TRANSFER_OUT_YUN(16, "可提现余额转出至云Mall")
    ;



    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberTransferType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberTransferType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Unknow;

            case 4:
                return TRANSFER_IN;
            case 5:
                return TRANSFER_OUT;
            case 6:
                return PAY_MENT;
            case 7:
                return PAY_MENT_FOR_PROXY;
            case 8:
                return RedEnvelope_TRANSFER_IN;
            case 9:
                return RedEnvelope_TRANSFER_OUT;
            case 10:
                return PreStored_TRANSFER_IN;
            case 11:
                return PreStored_TRANSFER_OUT;
            case 12:
                return PreStored_Pay;
            case 16:
                return TRANSFER_OUT_YUN;
            default:
                return Unknow;
        }
    }
}
