package com.sky.dao.echarts;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class Legend {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public Legend(List<String> data) {
        this.data = data;
    }
}
