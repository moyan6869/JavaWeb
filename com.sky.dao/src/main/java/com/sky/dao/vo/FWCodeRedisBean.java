package com.sky.dao.vo;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 防伪码实体
 * @Date: 2016/7/13 14:55
 */
public class FWCodeRedisBean {
    private String orderCode;
    private String xCode;
    private String bCode;
    private String productId;
    private String barCode;
    private String codeTypeStr;
    private Date shipDate= new Date();

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getxCode() {
        return xCode;
    }

    public void setxCode(String xCode) {
        this.xCode = xCode;
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getCodeTypeStr() {
        return codeTypeStr;
    }

    public void setCodeTypeStr(String codeTypeStr) {
        this.codeTypeStr = codeTypeStr;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }
}
