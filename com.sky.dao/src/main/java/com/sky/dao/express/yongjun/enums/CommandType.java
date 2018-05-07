package com.sky.dao.express.yongjun.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.enums
 * @company: SIBU Kanger
 * @Description: 永骏物流接口命令参数
 * @Date: 2016/4/28 9:47
 */
public class CommandType {
    //添加产品
    public final static int addProduct = 11;

    //产品入库
    public final static int addPurchasOrder = 12;

    //订单推送
    public final static int addPushOrder = 13;

    //根据快递单号和快递公司获取快递信息
    public final static int findExpressMsg = 14;

}
