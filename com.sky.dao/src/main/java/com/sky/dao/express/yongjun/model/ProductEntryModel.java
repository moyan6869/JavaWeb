package com.sky.dao.express.yongjun.model;

import java.util.Date;
import java.util.List;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 产品入库
 * @Date: 2016/4/28 10:56
 */
public class ProductEntryModel {
    private String orderCode;
    private Integer orderType;
    private Date createDate;
    private String orderRemark;
    private List<ProductEntryDetailModel> orderProducts;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }


    public List<ProductEntryDetailModel> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<ProductEntryDetailModel> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
