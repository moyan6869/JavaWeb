package com.sky.dao.staysend;

import com.alibaba.fastjson.annotation.JSONField;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;

public class StaySendOrder {

    private String billNum;
    private String billType = "sendOrder";
    private String customerCode;
    private String customerName;
    private String linker;
    private String phone;
    private String address;

    private List<OrderItem> lineData;
    @JSONField(serialize=false)
    private String lineNum;
    @JSONField(serialize=false)
    private String itemCode;
    @JSONField(serialize=false)
    private Integer inQty;
//    @JSONField(serialize=false)
//    private Integer orderType;
//    @JSONField(serialize=false)
//    private String productId;


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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLinker() {
        return linker;
    }

    public void setLinker(String linker) {
        this.linker = linker;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItem> getLineData() {
        return lineData;
    }

    public void setLineData(List<OrderItem> lineData) {
        this.lineData = lineData;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getInQty() {
        return inQty;
    }

    public void setInQty(Integer inQty) {
        this.inQty = inQty;
    }

    @Override
    public String toString() {
        return "StaySendOrder{" +
                "billNum='" + billNum + '\'' +
                ", billType='" + billType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", customerName='" + customerName + '\'' +
                ", linker='" + linker + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lineData=" + lineData +
                ", lineNum='" + lineNum + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", inQty=" + inQty +
                '}';
    }
}
