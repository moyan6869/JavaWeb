package com.sky.web.model;

import java.io.Serializable;

/**
 * Created by 建帆 on 2015/11/28.
 */
public class AddMember  implements Serializable {
    private static final long serialVersionUID = 102L;

    private String phone;
    private String password;
    private String nickName;
    private Integer type;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
