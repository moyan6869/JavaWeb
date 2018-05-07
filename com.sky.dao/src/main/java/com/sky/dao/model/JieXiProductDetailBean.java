package com.sky.dao.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/8/11 15:13
 */
public class JieXiProductDetailBean {
    private String productCode;
    public String EAN13;
    private Integer quant=0;
    private String productName;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getEAN13() {
        return EAN13;
    }

    public void setEAN13(String EAN13) {
        this.EAN13 = EAN13;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
