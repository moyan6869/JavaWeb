package com.sky.dao.vo;

/**
 * Created by 建帆 on 2015/12/21.
 */
public class KuaiGouSysUserBean {
    //0、 小白用户，1、注册用户，不存在上级，2、注册用户，存在上级
    private int type;
    private String parentPhone;
    private String phone;
    private int status;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
