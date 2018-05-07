package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by weiyunliang on 2017/10/18.
 */
public class LoginBean implements Serializable {
    private String username;
    private String password;
    private String name;
    private int loginTAG;
    private int logincount;
    private int teamFlag;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getLoginTAG() {
        return loginTAG;
    }

    public void setLoginTAG(int loginTAG) {
        this.loginTAG = loginTAG;
    }

    public int getLogincount() {
        return logincount;
    }

    public int getTeamFlag() {
        return teamFlag;
    }

    public void setTeamFlag(int teamFlag) {
        this.teamFlag = teamFlag;
    }

    public void setLogincount(int logincount) {
        this.logincount = logincount;
    }

    public void setName(String name) {
        this.name = name;
    }
}
