package com.sky.dao.fangwei.model.vo;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by Administrator on 2015/12/23.
 */
public class APIOrderDetail {
    private String itemCode;
    private String itemName;
    private int quantity;
    @JsonProperty("SerialNumber")
    private String serialNumber;
    @JsonProperty("TwoDimensionCode")
    private String twoDimensionCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTwoDimensionCode() {
        return twoDimensionCode;
    }

    public void setTwoDimensionCode(String twoDimensionCode) {
        this.twoDimensionCode = twoDimensionCode;
    }
}
