package com.sky.dao.staysend;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class OrderExpress {



    private String billNum;//订单号
    private String billType;//单据类型
    @JsonProperty(value = "Co")
    private String Co;//物流公司
    private String number;//物流单号
    private String customerCode;//送货客户地址

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getCo() {
        return Co;
    }

    public void setCo(String co) {
        Co = co;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
