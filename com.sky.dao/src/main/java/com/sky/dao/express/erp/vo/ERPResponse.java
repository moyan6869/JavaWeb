package com.sky.dao.express.erp.vo;

/**
 * Created by wangyun on 2015/12/11.
 */
public class ERPResponse {
    private boolean isSuccess;
    private String msg;
    private String orderNo;
    private String erpNo;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getErpNo() {
        return erpNo;
    }

    public void setErpNo(String erpNo) {
        this.erpNo = erpNo;
    }

    @Override
    public String toString() {
        return "ERPResponse{" +
                "isSuccess=" + isSuccess +
                ", msg='" + msg + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", erpNo='" + erpNo + '\'' +
                '}';
    }
}
