package com.sky.dao.express.yto.model.product;

/**
 * Created by wangyun on 2015/12/10.
 */
public class Product {

    /// 商品编码	字符	32	要求唯一		是
    private String productCode;

    /// 商品类别	枚举数字	32	使用枚举数字		是  ProductTypeId
    private int productTypeId;

    /// 商品名称	字符	128			是
    private String productName;

    /// 商品型号	字符	128			是
    private String pattern;

    /// 	计量单位	枚举字符	16	使用枚举字符		是  :  用于传输字符
    private String measure;

    /// 商品条码	字符	32
    private String barCode;

    /// 质检方案	枚举数字	32	使用枚举数字		是  ProductQualityScheme
    private int qualityTestScheme;

    /// 库存预警下限	数字		0-1000000 	0	是
    private int inventoryMin;

    /// 批次生成方案	枚举数字		使用枚举数字		是 ProductQualityScheme
    private int batchScheme;

    /// 长	数字		单位厘米	0
    private int length;

    /// 宽	数字		单位厘米	0
    private int width;

    /// 高	数字		单位厘米	0
    private int height;

    /// 	毛重	数字		单位克	0
    private Integer grossweight;

    /// 净重	数字		单位克	0
    private int suttleweight;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getQualityTestScheme() {
        return qualityTestScheme;
    }

    public void setQualityTestScheme(int qualityTestScheme) {
        this.qualityTestScheme = qualityTestScheme;
    }

    public int getInventoryMin() {
        return inventoryMin;
    }

    public void setInventoryMin(int inventoryMin) {
        this.inventoryMin = inventoryMin;
    }

    public int getBatchScheme() {
        return batchScheme;
    }

    public void setBatchScheme(int batchScheme) {
        this.batchScheme = batchScheme;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(Integer grossweight) {
        this.grossweight = grossweight;
    }

    public int getSuttleweight() {
        return suttleweight;
    }

    public void setSuttleweight(int suttleweight) {
        this.suttleweight = suttleweight;
    }
}

