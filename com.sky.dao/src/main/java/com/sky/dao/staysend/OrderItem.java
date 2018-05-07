package com.sky.dao.staysend;

public class OrderItem {

    private String lineNum;
    private String itemCode;
    private Integer inQty;

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
        return "OrderItem{" +
                "lineNum='" + lineNum + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", inQty=" + inQty +
                '}';
    }
}
