package com.sky.dao.express.yongjun.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/5/5 10:41
 */
public class OrderExpresUpdateModel {
    private String orderCode;
    private String token;
    private String expressName;
    private String expressCode;
    private Integer expressWeight;
    private String cartonNo;
    private Integer cartonQuantity;
    private Integer orderFrom;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public Integer getExpressWeight() {
        return expressWeight;
    }

    public void setExpressWeight(Integer expressWeight) {
        this.expressWeight = expressWeight;
    }

    public String getCartonNo() {
        return cartonNo;
    }

    public void setCartonNo(String cartonNo) {
        this.cartonNo = cartonNo;
    }

    public Integer getCartonQuantity() {
        return cartonQuantity;
    }

    public void setCartonQuantity(Integer cartonQuantity) {
        this.cartonQuantity = cartonQuantity;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }
}
