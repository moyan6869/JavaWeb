package com.sky.dao.express.yongjun.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/4/28 16:15
 */
public class YongJunResponse<T> {
private Integer code;
    private String message;
    private T data;

    public YongJunResponse(){}

    public YongJunResponse(Integer inCode,String inMessage,T inDate){
        this.code=inCode;
        this.message=inMessage;
        this.data=data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
