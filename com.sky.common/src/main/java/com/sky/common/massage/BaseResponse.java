package com.sky.common.massage;

import java.io.Serializable;


public class BaseResponse implements Serializable{

    public class BaseObject implements Serializable {

    }
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code = Status.SUCCESS;
    
    private String message;

    private Object data=new BaseObject();
    public BaseResponse() {
    }

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse(Integer code) {
        this.code = code;
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse setCode(Integer code) {
        this.code = code;
        return this;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
