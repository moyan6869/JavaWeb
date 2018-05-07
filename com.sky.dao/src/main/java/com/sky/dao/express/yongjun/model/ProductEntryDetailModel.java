package com.sky.dao.express.yongjun.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 产品入库明细
 * @Date: 2016/4/28 10:59
 */
public class ProductEntryDetailModel {
    private String barCode;
    private Integer quantity;
    private Integer confirmquantity;
    private Integer errorquantity;
    private String remark;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getConfirmquantity() {
        return confirmquantity;
    }

    public void setConfirmquantity(Integer confirmquantity) {
        this.confirmquantity = confirmquantity;
    }

    public Integer getErrorquantity() {
        return errorquantity;
    }

    public void setErrorquantity(Integer errorquantity) {
        this.errorquantity = errorquantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
