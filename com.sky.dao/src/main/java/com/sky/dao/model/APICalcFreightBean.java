package com.sky.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public class APICalcFreightBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String addressId;
    private String memberId;
    private Integer addUpType=0;
    private Long payMoney=0l;
    private String MemberId;
    private List<APIAddOrderProductBean> products = new ArrayList<APIAddOrderProductBean>();

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

    public Integer getAddUpType() {
        return addUpType;
    }

    public Long getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Long payMoney) {
        this.payMoney = payMoney;
    }

    public void setAddUpType(Integer addUpType) {
        this.addUpType = addUpType;
    }

    @Override
    public String toString() {
        return "APICalcFreightBean{" +
                "addressId='" + addressId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", addUpType=" + addUpType +
                ", products=" + products +
                '}';
    }
}
