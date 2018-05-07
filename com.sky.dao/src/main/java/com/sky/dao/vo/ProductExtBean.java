package com.sky.dao.vo;

/**
 * Created by 建帆 on 2015/12/16.
 */
public class ProductExtBean {

    private String productId;
    private String productSkuid;
    // 商品类别
    private Integer productTypeid;
    //商品型号
    private String pattern;
    //商品条码
    private String barCode;
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
    private Integer productWidth=0;
    //高 int 单位厘米
    private Integer productHeight=0;
    //毛重 int 单位克
    private Integer grossWeight=0;
    //净重 int 单位克
    private Integer suttleWeight=0;
    //产品名称
    private String productName;
    //内包装数量
    private Integer boxcase;
    //产品名称
    private String categoryName;
    //是否推送
    private Integer isPut;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductSkuid() {
        return productSkuid;
    }

    public void setProductSkuid(String productSkuid) {
        this.productSkuid = productSkuid;
    }

    public Integer getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Integer productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    public Integer getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Integer productWidth) {
        this.productWidth = productWidth;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getBoxcase() {
        return boxcase;
    }

    public void setBoxcase(Integer boxcase) {
        this.boxcase = boxcase;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getIsPut() {
        return isPut;
    }

    public void setIsPut(Integer isPut) {
        this.isPut = isPut;
    }
}
