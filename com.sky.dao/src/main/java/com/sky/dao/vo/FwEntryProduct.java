package com.sky.dao.vo;

/**
 * Created by ye on 2016-7-13.
 */
public class FwEntryProduct {
    private String entry1Id;
    private String entryId;
    private String productId;
    private String productName;
    private String barCode;
    private Integer quant;

    public String getEntry1Id() {
        return entry1Id;
    }

    public void setEntry1Id(String entry1Id) {
        this.entry1Id = entry1Id;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }
}
