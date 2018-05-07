package com.sky.dao.model;

/**
 * Created by Administrator on 2016/1/19.
 */
public class APIBankBranch {

    private int bankId;
    private String province;
    private String city;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
