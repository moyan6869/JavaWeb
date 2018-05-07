package com.sky.dao.express.yongjun.model;

import java.util.List;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/5/6 11:28
 */
public class ProductEntryRequestModel {
    private String orderCode;
    private String confirmer;
    private String confirmDate;
    private String confirmEntryRemark;
    private List<ProductEntryDetailRequestModel> entryProducts;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(String confirmer) {
        this.confirmer = confirmer;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getConfirmEntryRemark() {
        return confirmEntryRemark;
    }

    public void setConfirmEntryRemark(String confirmEntryRemark) {
        this.confirmEntryRemark = confirmEntryRemark;
    }

    public List<ProductEntryDetailRequestModel> getEntryProducts() {
        return entryProducts;
    }

    public void setEntryProducts(List<ProductEntryDetailRequestModel> entryProducts) {
        this.entryProducts = entryProducts;
    }
}
