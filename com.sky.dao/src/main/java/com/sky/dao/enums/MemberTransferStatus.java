package com.sky.dao.enums;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/22
 * Description:转账业务表状态标识
 */
public enum MemberTransferStatus {
    Unknow(0, "初始化"),
    SUCESS(1, "成功"),
    FAILURE(2, "失败");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private MemberTransferStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static MemberTransferStatus valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return SUCESS;
            case 2:
                return FAILURE;
            default:
                return Unknow;
        }
    }
}
