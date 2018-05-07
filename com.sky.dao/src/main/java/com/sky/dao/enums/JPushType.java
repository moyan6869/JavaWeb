package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public enum JPushType {
	Unknow(0, "无推送"),
    UserRegister(1, "用户注册"),
    Benefit(2, "收益通知"),
	Achivement(3,"冠升级"),
	IsMember(4,"成为会员"),
	NewMember(5,"市场新会员"),
	Other(100, "其他");
    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private JPushType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static JPushType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return UserRegister;
            case 2:
                return Benefit;
            case 3:
            	return Achivement;
            case 4:
            	return IsMember;
            case 5:
            	return NewMember;
            case 100:
                return Other;
            
            default:
                return Unknow;
        }
    }
}
