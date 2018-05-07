package com.sky.dao.express.yto.vo;

/**
 * 圆通系统推送给ERP(第三方系统)的报文格式
 * Created by wangyun on 2015/12/10.
 */
public class YTORequestInfo {
    private String dataXml;
    private String dataDigestJson;
    private String dataDigestXml;
    private String dataJson;

    public String getDataXml() {
        return dataXml;
    }

    public void setDataXml(String dataXml) {
        this.dataXml = dataXml;
    }

    public String getDataDigestJson() {
        return dataDigestJson;
    }

    public void setDataDigestJson(String dataDigestJson) {
        this.dataDigestJson = dataDigestJson;
    }

    public String getDataDigestXml() {
        return dataDigestXml;
    }

    public void setDataDigestXml(String dataDigestXml) {
        this.dataDigestXml = dataDigestXml;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }
}