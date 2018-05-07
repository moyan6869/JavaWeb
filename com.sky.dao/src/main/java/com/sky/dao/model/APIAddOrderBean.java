package com.sky.dao.model;

import java.util.List;

/**
 * Created by Administrator on 2015/10/22.
 */
public class APIAddOrderBean {
    private String addressId;
    private List<APIAddOrderProductBean> products;
    private Integer orderFrom;//
    private String express;
    private String remark;
    private String memberId;
    private Integer addUpType=0;//0、累计升级，1、复消升级
    private Integer discountMoney =0;//折扣后价格
    private String  discountId ;//折扣券Id
    private int discount = 100;
    private int money;//把这之后的价格
    private int payType;
    private String type; //类型  compound 或者  change

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Integer getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Integer discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public List<APIAddOrderProductBean> getProducts() {
        return products;
    }
    public void setProducts(List<APIAddOrderProductBean> products) {
        this.products = products;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
    }

    public String getExpress() {
        return express;
    }
    public void setExpress(String express) {
        this.express = express;
    }

    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

    public Integer getAddUpType() {
        return addUpType;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public void setAddUpType(Integer addUpType) {
        this.addUpType = addUpType;
    }

    @Override
    public String toString() {
        return "APIAddOrderBean{" +
                "addressId='" + addressId + '\'' +
                ", products=" + products +
                ", orderFrom=" + orderFrom +
                ", express='" + express + '\'' +
                ", remark='" + remark + '\'' +
                ", memberId='" + memberId + '\'' +
                ", addUpType=" + addUpType +
                ", discountMoney=" + discountMoney +
                ", discountId='" + discountId + '\'' +
                ", discount=" + discount +
                ", money=" + money +
                '}';
    }
}