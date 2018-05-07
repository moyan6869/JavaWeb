package com.sky.dao.model;

import java.util.List;

/**
 * Created by Administrator on 2016/1/19.
 */
public class APIBankBranchInfo {
    private String areaCode;
    private List<String> addresses;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String code) {
        this.areaCode = code;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
