package com.sky.dao.zxfw;

import java.util.*;
/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 兆信防伪订单推送实体
 * @Date: 2016/7/12 10:28
 */
public class ZXOrderRequest extends ZXBaseRequest{

    private String orderCode;
    private String warehouseCode;
    private List<ZXOrderProductRequest> products;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public List<ZXOrderProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ZXOrderProductRequest> products) {
        this.products = products;
    }
}


