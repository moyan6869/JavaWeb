package com.sky.dao.enums;

/**
 * Created by lenovo on 2016/12/20.
 */
public enum MemberLimitLogTypeEnums {
    AddByOrder(0,"默认报单获得"),
    AddByPerson(1,"手工调整高级别增加"),
    ReduceByOrder(2,"退单减少"),
    ReduceByPerson(3,"手工调整低级别减少"),
    AddByYwsMember(4,"原云微商政策优惠增加"),
    WinningLuckDraw(5,"大转盘中奖");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberLimitLogTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberLimitLogTypeEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return AddByOrder;
            case 1:
                return AddByPerson;
            case 2:
                return ReduceByOrder;
            case 3:
                return ReduceByPerson;
            case 4:
                return AddByYwsMember;
            case 5:
                return WinningLuckDraw;
            default:
                return AddByOrder;
        }
    }
}
