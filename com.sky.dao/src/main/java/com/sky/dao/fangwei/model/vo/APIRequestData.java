package com.sky.dao.fangwei.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class APIRequestData {
    private String pdaOrderNum;
    private Date docDate;
    private String erpOrderNum;
    private List<APIOrderDetail> lines = new ArrayList<APIOrderDetail>();

    public String getPdaOrderNum() {
        return pdaOrderNum;
    }

    public void setPdaOrderNum(String pdaOrderNum) {
        this.pdaOrderNum = pdaOrderNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getErpOrderNum() {
        return erpOrderNum;
    }

    public void setErpOrderNum(String erpOrderNum) {
        this.erpOrderNum = erpOrderNum;
    }

    public List<APIOrderDetail> getLines() {
        return lines;
    }

    public void setLines(List<APIOrderDetail> lines) {
        this.lines = lines;
    }
}
