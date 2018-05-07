package com.sky.dao.express.yto.model.product;

/**
 * 批次生成方案枚举：1：入库日期相同；2：生产日期相同；3：过期日期相同；
 * Created by wangyun on 2015/12/10.
 */
public class ProductBatchScheme {
    public final static int storageDateSame = 1;
    public final static int productionDateSame = 2;
    public final static int expirationDateSame = 3;
}
