package com.sky.dao.zxfw;

import java.util.*;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 兆信防伪写入入库订单接口
 * @Date: 2016/7/12 16:58
 */
public class ZXEntryOrderRequest extends ZXBaseRequest{


    /*入库编码*/
    private String entryCode;

    /*库房编码*/
    private String warehouseCode;

    private Integer entryType=0;

    /*开始时间 yyyy-MM-dd HH:mm*/
    private String starDtStr;

    /*结束时间 yyyy-MM-dd HH:mm*/
    private String  endDtStr;

    /*入库产品集合和数量*/
    private List<ZXOrderProductRequest> products;

    public String getEntryCode() {
        return entryCode;
    }

    public void setEntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public String getStarDtStr() {
        return starDtStr;
    }

    public void setStarDtStr(String starDtStr) {
        this.starDtStr = starDtStr;
    }

    public String getEndDtStr() {
        return endDtStr;
    }

    public void setEndDtStr(String endDtStr) {
        this.endDtStr = endDtStr;
    }

    public List<ZXOrderProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ZXOrderProductRequest> products) {
        this.products = products;
    }
}
