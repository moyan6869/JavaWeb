package com.sky.dao.express.yto.vo;

/**
 * Created by wangyun on 2015/12/11.
 */
public class YTOResponse {
    // 异常编码
    private String errorCode;
    // 错误提示
    private String msg;
    // 是否成功(字符)  默认值 true false
    private boolean success;
    // 圆通单号
    private String ytoxlCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getYtoxlCode() {
        return ytoxlCode;
    }

    public void setYtoxlCode(String ytoxlCode) {
        this.ytoxlCode = ytoxlCode;
    }

    @Override
    public String toString() {
        return "YTOResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", ytoxlCode='" + ytoxlCode + '\'' +
                '}';
    }
}
