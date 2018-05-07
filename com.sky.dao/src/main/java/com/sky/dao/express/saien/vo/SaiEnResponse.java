package com.sky.dao.express.saien.vo;

/**
 * Created by Administrator on 2015/12/25.
 */
public class SaiEnResponse {
    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SaiEnResponse{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}