package com.sky.dao.express.saien.model.request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/25.
 */
public class edbTradeCancel_order {
    private List<edbTradeCancel_orderInfo> orderInfo = new ArrayList<edbTradeCancel_orderInfo>();

    public List<edbTradeCancel_orderInfo> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<edbTradeCancel_orderInfo> orderInfo) {
        this.orderInfo = orderInfo;
    }
}
