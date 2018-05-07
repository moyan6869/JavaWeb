package com.sky.dao.staysend;

import java.util.List;

public class OrderExpressDto {

    private String message;
    private String state;
    private String successCount;

    private List<OrderExpress> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount;
    }

    public List<OrderExpress> getData() {
        return data;
    }

    public void setData(List<OrderExpress> data) {
        this.data = data;
    }
}
