package com.sky.common.massage;

import java.util.List;
 
public class DataResponse extends BaseResponse {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object data=new Object();

    public DataResponse() {
        super();
    }

    public DataResponse(String message) {
        super(message);
    }

    public DataResponse (Object data) {
        this.data = data;
    }

    public DataResponse(Integer code) {
        super(code);
    }

    public DataResponse(Integer code, String message) {
        super(code, message);
    }
    
    public DataResponse(Integer code, String message,Object data) {
        super(code, message);
        this.data=data;
    }

    public DataResponse setData(List<?> data) {
        this.data = data;
        return this;
    }

    public Object getData() {
        return data;
    }
}
