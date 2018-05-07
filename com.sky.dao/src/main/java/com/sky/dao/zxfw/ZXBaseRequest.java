package com.sky.dao.zxfw;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 调用兆信接口基本请求参数
 * @Date: 2016/7/12 9:31
 */
public class ZXBaseRequest {
    protected String cid;
    protected String authtoken;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }
}
