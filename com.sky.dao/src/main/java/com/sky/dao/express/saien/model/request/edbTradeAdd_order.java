package com.sky.dao.express.saien.model.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/25.
 */
public class edbTradeAdd_order {
    private edbTradeAdd_orderInfo orderInfo;
    private List<edbTradeAdd_product_item> productInfo = new ArrayList<edbTradeAdd_product_item>();

    public edbTradeAdd_orderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(edbTradeAdd_orderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<edbTradeAdd_product_item> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<edbTradeAdd_product_item> productInfo) {
        this.productInfo = productInfo;
    }
}
