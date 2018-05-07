package com.sky.dao.express.yto.api;

/**
 * Created by Administrator on 2015/12/14.
 */
public class ProductSkuAddModel {
    private String productCode;
    private String skuCode;
    private String SkuName;
    private String barCode;
    private String pattern;

    //计量单位
    private String measure;
    //质检方案
    private Integer qualityScheme;
    //库存预警下限
    private Integer inventoryMin;
    //批次生成方案
    private Integer batchScheme;
    //长 int 单位厘米
    private Integer productLength=0;
    //宽  int 单位厘米

    public Integer getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Integer productWidth) {
        this.productWidth = productWidth;
    }

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

    public String getSkuName() {
        return SkuName;
    }

    public void setSkuName(String skuName) {
        SkuName = skuName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Integer getQualityScheme() {
        return qualityScheme;
    }

    public void setQualityScheme(Integer qualityScheme) {
        this.qualityScheme = qualityScheme;
    }

    public Integer getInventoryMin() {
        return inventoryMin;
    }

    public void setInventoryMin(Integer inventoryMin) {
        this.inventoryMin = inventoryMin;
    }

    public Integer getBatchScheme() {
        return batchScheme;
    }

    public void setBatchScheme(Integer batchScheme) {
        this.batchScheme = batchScheme;
    }

    public Integer getProductLength() {
        return productLength;
    }

    public void setProductLength(Integer productLength) {
        this.productLength = productLength;
    }

    public Integer getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Integer productHeight) {
        this.productHeight = productHeight;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Integer getSuttleWeight() {
        return suttleWeight;
    }

    public void setSuttleWeight(Integer suttleWeight) {
        this.suttleWeight = suttleWeight;
    }

    private Integer productWidth=0;
    //高 int 单位厘米
    private Integer productHeight=0;
    //毛重 int 单位克
    private Integer grossWeight=0;
    //净重 int 单位克
    private Integer suttleWeight=0;
}
