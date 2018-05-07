package com.sky.dao.express.yto.model.order;

/**
 * Created by Administrator on 2015/12/11.
 */
public class OrderDetail {
    //商品编码	字符	32			是
    private String productCode;
    //规格编码	字符	32			是
    private String skuCode;
    //入库数量	整数	0-1000000	大于0小于1000000		是
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
