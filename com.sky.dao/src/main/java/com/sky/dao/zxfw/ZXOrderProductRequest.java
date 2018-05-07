package com.sky.dao.zxfw;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/7/12 10:31
 */
public class ZXOrderProductRequest {
    private String productCode;
    public String EAN13;
    private Integer quant=0;

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
}
