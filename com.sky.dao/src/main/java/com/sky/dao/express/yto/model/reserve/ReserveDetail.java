package com.sky.dao.express.yto.model.reserve;

/**
 * 入库单明细
 * Created by wangyun on 2015/12/10.
 */
public class ReserveDetail {
    //商品编码	字符	32			是
    public String productCode;
    //规格编码	字符	32			是
    public String skuCode;
    // 入库数量	整数	0-1000000	大于0小于1000000		是
    public int number;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
