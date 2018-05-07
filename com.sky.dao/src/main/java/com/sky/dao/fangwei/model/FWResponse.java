package com.sky.dao.fangwei.model;

/**
 * Created by Administrator on 2015/12/23.
 */
public class FWResponse {
    private boolean success;
    private String result;
    private String errormsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    @Override
    public String toString() {
        return "FWResponse{" +
                "success=" + success +
                ", result='" + result + '\'' +
                ", errormsg='" + errormsg + '\'' +
                '}';
    }
}
