package com.sky.dao.echarts;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class Series {
    private String name;
    private String type;
    private String stack;
    private List<Long> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<Long> getData() {
        return data;
    }

    public void setData(List<Long> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", stack='" + stack + '\'' +
                ", data=" + data +
                '}';
    }

    public Series() {
    }

    public Series(String name, String type, String stack, List<Long> data) {
        this.name = name;
        this.type = type;
        this.stack = stack;
        this.data = data;
    }
}
