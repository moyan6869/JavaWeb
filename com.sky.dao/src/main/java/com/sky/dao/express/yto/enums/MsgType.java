package com.sky.dao.express.yto.enums;

/**
 * 接口类型
 * Created by wangyun on 2015/12/10.
 */
public class MsgType {

    // 创建销售订单
    public final static String ZEBRAOUTSTOCK_SAVE = "ZEBRAOUTSTOCK_SAVE";
    // 取消销售订单
    public final static String ZEBRAOUTSTOCK_CANCEL = "ZEBRAOUTSTOCK_CANCEL";
    // 获得库存余量
    public final static String INVENTORY_SYNC_DAY = "INVENTORY_SYNC_DAY";
    // 入库单创建
    public final static String RESERVE_SAVE = "RESERVE_SAVE";
    // 入库单取消
    public final static String RESERVE_CANCEL = "RESERVE_CANCEL";
    // 商品创建/修改
    public final static String PRODUCT_SAVE_UPDATE = "PRODUCT_SAVE_UPDATE";
    // 规格创建/修改（SKU）
    public final static String SKU_SAVE_UPDATE = "SKU_SAVE_UPDATE";
    // 退货出库单新增
    public final static String REJECTBILL_SAVE = "REJECTBILL_SAVE";
    // 取消退货出库单
    public final static String REJECTBILL_CANCEL = "REJECTBILL_CANCEL";
    // 损益单新增
    public final static String GAL_SAVE = "GAL_SAVE";
    // 取消损益单
    public final static String GAL_CANCEL = "GAL_CANCEL";
    // 调拨单新增
    public final static String ALLOT_SAVE = "ALLOT_SAVE";
    //取消调拨单
    public final static String ALLOT_CANCEL = "ALLOT_CANCEL";
    // 渠道新增/修改
    public final static String CHANNEL_SAVE = "CHANNEL_SAVE";
    // 禁用渠道
    public final static String CHANNEL_FORBIDDEN = "CHANNEL_FORBIDDEN";
    // 获得第三方可用仓库列表
    public final static String WAREHOUSE_LIST = "WAREHOUSE_LIST";
}
