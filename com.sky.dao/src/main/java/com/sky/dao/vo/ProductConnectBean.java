package com.sky.dao.vo;

/**
 * Created by 建帆 on 2015/12/28.
 */
public class ProductConnectBean {

    //组合产品ID
    private String productId;

    //关联产品ID
    private  String connectProductId;

    //组合套装关联产品数量
    private int connectProductQuantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getConnectProductId() {
        return connectProductId;
    }

    public void setConnectProductId(String connectProductId) {
        this.connectProductId = connectProductId;
    }

    public int getConnectProductQuantity() {
        return connectProductQuantity;
    }

    public void setConnectProductQuantity(int connectProductQuantity) {
        this.connectProductQuantity = connectProductQuantity;
    }
}
