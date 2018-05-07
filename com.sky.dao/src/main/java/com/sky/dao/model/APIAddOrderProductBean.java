package com.sky.dao.model;

/**
 * Created by Administrator on 2015/10/22.
 */
public class APIAddOrderProductBean {
    private String productId;
    private Integer amount;

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "APIAddOrderProductBean{" +
                "productId='" + productId + '\'' +
                ", amount=" + amount +
                '}';
    }
}