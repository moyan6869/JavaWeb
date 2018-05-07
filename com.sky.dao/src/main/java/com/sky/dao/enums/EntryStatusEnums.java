package com.sky.dao.enums;

/**
 * Created by 叶子林 on 2016/8/30.
 */
public enum EntryStatusEnums {
    NotEntry(0, "未入库"),
    PushEntry(1, "推送入库"),
    EConfirmEntry(2, "快递公司确认入库"),
    LConfirmEntry(3, "物流核实入库");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private EntryStatusEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static EntryStatusEnums valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return NotEntry;
            case 1:
                return PushEntry;
            case 2:
                return EConfirmEntry;
            case 3:
                return LConfirmEntry;
            default:
                return NotEntry;
        }
    }
}
