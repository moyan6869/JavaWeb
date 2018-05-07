package com.sky.dao.fangwei.model;

/**
 * Created by Administrator on 2015/12/23.
 */
public class FWOrderDetail {
    private String prodcode;
    private int quantity;
    private String whsCode;

    public String getProdcode() {
        return prodcode;
    }

    public void setProdcode(String prodcode) {
        this.prodcode = prodcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }
}
