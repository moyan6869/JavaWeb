package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by weiyunliang on 2017/10/18.
 */
public class AnBean implements Serializable {
    private int pid;
    private int id;
    private String cont;
    public AnBean(int pid, int id, String cont)
    {
        this.pid = pid;
        this.id = id;
        this.cont = cont;
    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}
