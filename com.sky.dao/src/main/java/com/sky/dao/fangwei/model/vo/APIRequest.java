package com.sky.dao.fangwei.model.vo;

import java.util.List;

/**
 * Created by Administrator on 2015/12/23.
 */
public class APIRequest {
    private String token;
    private String companyCode;
    private List<APIRequestData> data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public List<APIRequestData> getData() {
        return data;
    }

    public void setData(List<APIRequestData> data) {
        this.data = data;
    }
}
