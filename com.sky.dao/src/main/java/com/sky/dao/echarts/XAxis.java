package com.sky.dao.echarts;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class XAxis {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public XAxis(List<String> data) {
        this.data = data;
    }
}
