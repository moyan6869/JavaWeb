package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class ProductSaleStatsVo  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String productId;

    private String brand;

    private String name;

    private String size;

    private String retailPriceStr;

    private Integer retailPrice;

    private String marketPriceStr;

    private Integer marketPrice;

    private String purchaseQuantityStr;

    private BigInteger purchaseQuantity;

    private String giftQuantityStr;

    private BigInteger giftQuantity;

    private String realQuantityStr;

    private String moneyStr;

    private BigInteger money;

    private String giftMoneyStr;

    private BigInteger giftMoney;

    private String realMoneyStr;

    private String remark;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getPurchaseQuantityStr() {
        return purchaseQuantityStr;
    }

    public void setPurchaseQuantityStr(String purchaseQuantityStr) {
        this.purchaseQuantityStr = purchaseQuantityStr;
    }

    public BigInteger getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(BigInteger purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getMoneyStr() {
        return moneyStr;
    }

    public void setMoneyStr(String moneyStr) {
        this.moneyStr = moneyStr;
    }

    public BigInteger getMoney() {
        return money;
    }

    public void setMoney(BigInteger money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRetailPriceStr() {
        return retailPriceStr;
    }

    public void setRetailPriceStr(String retailPriceStr) {
        this.retailPriceStr = retailPriceStr;
    }

    public String getMarketPriceStr() {
        return marketPriceStr;
    }

    public void setMarketPriceStr(String marketPriceStr) {
        this.marketPriceStr = marketPriceStr;
    }

    public String getGiftQuantityStr() {
        return giftQuantityStr;
    }

    public void setGiftQuantityStr(String giftQuantityStr) {
        this.giftQuantityStr = giftQuantityStr;
    }

    public BigInteger getGiftQuantity() {
        return giftQuantity;
    }

    public void setGiftQuantity(BigInteger giftQuantity) {
        this.giftQuantity = giftQuantity;
    }

    public String getRealQuantityStr() {
        return realQuantityStr;
    }

    public void setRealQuantityStr(String realQuantityStr) {
        this.realQuantityStr = realQuantityStr;
    }

    public String getGiftMoneyStr() {
        return giftMoneyStr;
    }

    public void setGiftMoneyStr(String giftMoneyStr) {
        this.giftMoneyStr = giftMoneyStr;
    }

    public BigInteger getGiftMoney() {
        return giftMoney;
    }

    public void setGiftMoney(BigInteger giftMoney) {
        this.giftMoney = giftMoney;
    }

    public String getRealMoneyStr() {
        return realMoneyStr;
    }

    public void setRealMoneyStr(String realMoneyStr) {
        this.realMoneyStr = realMoneyStr;
    }
}
