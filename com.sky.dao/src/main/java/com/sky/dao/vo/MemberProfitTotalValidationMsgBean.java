package com.sky.dao.vo;

import java.io.Serializable;

/**
 * 会员总收益校验结果bean
 * Created by zhangcp on 2016/4/22.15:40
 */
public class MemberProfitTotalValidationMsgBean implements Serializable {
    /**
     * 运营系统名称
     */
    private String systemName;
    /**
     * 会员姓名
     */
    private String userName;
    /**
     * 会员手机号
     */
    private String phone;
    /**
     * 数据校验结果
     */
    private String msg;

    public String getSystemName() {
        if(systemName==null){
            return "";
        }
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
