package com.sky.dao.express.yto.api;

public class OrderAddProduct {
    private String productCode;
    private String productSKuCode;
    private int quantity;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductSKuCode() {
        return productSKuCode;
    }

    public void setProductSKuCode(String productSKuCode) {
        this.productSKuCode = productSKuCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
