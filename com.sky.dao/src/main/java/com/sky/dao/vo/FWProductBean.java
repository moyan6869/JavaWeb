package com.sky.dao.vo;

import com.sky.dao.model.ProductDetail;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/7/14 11:22
 */
public class FWProductBean {
    private  FWCodeRedisBean fwCode;
    private ProductDetail product;
    private long count=0;
    private String shipDate;
    public FWCodeRedisBean getFwCode() {
        return fwCode;
    }

    public void setFwCode(FWCodeRedisBean fwCode) {
        this.fwCode = fwCode;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public void setProduct(ProductDetail product) {
        this.product = product;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }



    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }
}
