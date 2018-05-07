package com.sky.dao.express.yto.vo;

/**
 * 圆通系统推送给ERP(第三方系统)单据类型
 * Created by wangyun on 2015/12/10.
 */
public class YTOBillType {
    //损益单
    public final static String gal = "gal";

    //调拨单
    public final static String allot = "allot";

    //销售出库单
    public final static String stockOut = "stockOut";

    //退货出库单
    public final static String rejectStockOut = "rejectStockOut";

    //采购入库单
    public final static String reserve = "reserve";

    //退货入库单
    public final static String rejectReserve = "rejectReserve";
}