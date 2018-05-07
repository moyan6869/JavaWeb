package com.sky.dao.express.yongjun.model;

import java.util.*;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 获取永骏快递信息返回参数
 * @Date: 2016/5/16 17:01
 */
public class ExpressMsgResponse {
   private Integer status;
    private String msg;
    private String billNo;
    private Integer traceNowType;
    private List<Object> traceRows;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Integer getTraceNowType() {
        return traceNowType;
    }

    public void setTraceNowType(Integer traceNowType) {
        this.traceNowType = traceNowType;
    }

    public List<Object> getTraceRows() {
        return traceRows;
    }

    public void setTraceRows(List<Object> traceRows) {
        this.traceRows = traceRows;
    }
}
