package com.sky.dao.enums;


public enum WarehouseStockCountType {
    SystemCount(0, "系统统计"),
    HandworkCount(1, "手工统计");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private WarehouseStockCountType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static WarehouseStockCountType valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return SystemCount;
            case 1:
                return HandworkCount;
            default:
                return SystemCount;
        }
    }
}
