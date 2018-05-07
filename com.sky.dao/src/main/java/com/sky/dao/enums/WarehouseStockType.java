package com.sky.dao.enums;

public enum WarehouseStockType {
    PurchaseEntry(0, "采购入库"),
    InterceptEntry(1, "拦截入库"),
    RefundEntry(2, "退货入库"),
    ExchangeEntry(3, "换货入库"),
    AllocationEntry(4, "调拨入库"),
    ReturnEntry(5, "返厂入库"),
    SallEntry(11, "销售出库"),
    ReissueEntry(12, "补发出库"),
    MaterialEntry (13, "物资出库"),
    AllocationDefectEntry(14, "调拨（次品）出库"),
    AllocationScrapEntry(15, "调拨(报废品)出库");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private WarehouseStockType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static WarehouseStockType valueOf(int value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return PurchaseEntry;
            case 1:
                return InterceptEntry;
            case 2:
                return RefundEntry;
            case 3:
                return ExchangeEntry;
            case 4:
                return AllocationEntry;
            case 5:
                return ReturnEntry;
            case 11:
                return SallEntry;
            case 12:
                return ReissueEntry;
            case 13:
                return MaterialEntry;
            case 14:
                return AllocationDefectEntry;
            case 15:
                return AllocationScrapEntry;
            default:
                return PurchaseEntry;
        }
    }
}
