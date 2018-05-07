package com.sky.dao.vo;

import com.sky.dao.express.yto.model.product.Product;
import com.sky.dao.model.ProductDetail;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
public class LuckIndianaProduct implements Serializable{
    private int code =0;
    private String msg;
    private String luckId;
    private String productId;
    private int productType;
    private String pname;
    private int price;
    private int totalQuantity;
    private int consumeQuantity;
    private int eachPrice;
    private int totalShareNumber;
    private int totalPayNumber;
    private int totalBuyNumber;
    private Date startDate;
    private Date endDate;
    private Date createDate;
    private Date updateDate;
    private int status;
    private ProductDetail productDetail;
    private String buyId;
    private boolean outOfDate;
    private int buySum;
    private int mount;
    private int isLottery;
    private String payCode;
    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public int getBuySum() {
        return buySum;
    }

    public void setBuySum(int buySum) {
        this.buySum = buySum;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public boolean isOutOfDate() {
        return outOfDate;
    }

    public void setOutOfDate(boolean outOfDate) {
        this.outOfDate = outOfDate;
    }

    public String getBuyId() {
        return buyId;
    }

    public void setBuyId(String buyId) {
        this.buyId = buyId;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getTotalPayNumber() {
        return totalPayNumber;
    }

    public void setTotalPayNumber(int totalPayNumber) {
        this.totalPayNumber = totalPayNumber;
    }

    public int getTotalBuyNumber() {
        return totalBuyNumber;
    }

    public void setTotalBuyNumber(int totalBuyNumber) {
        this.totalBuyNumber = totalBuyNumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLuckId() {
        return luckId;
    }

    public void setLuckId(String luckId) {
        this.luckId = luckId;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getConsumeQuantity() {
        return consumeQuantity;
    }

    public void setConsumeQuantity(int consumeQuantity) {
        this.consumeQuantity = consumeQuantity;
    }

    public int getEachPrice() {
        return eachPrice;
    }

    public void setEachPrice(int eachPrice) {
        this.eachPrice = eachPrice;
    }

    public int getTotalShareNumber() {
        return totalShareNumber;
    }

    public void setTotalShareNumber(int totalShareNumber) {
        this.totalShareNumber = totalShareNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsLottery() {
        return isLottery;
    }

    public void setIsLottery(int isLottery) {
        this.isLottery = isLottery;
    }
}
