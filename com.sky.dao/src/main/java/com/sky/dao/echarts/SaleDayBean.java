package com.sky.dao.echarts;

/**
 * Created by Administrator on 2017/12/19.
 */
public class SaleDayBean {
    private String date;
    private Long count;
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SaleDayBean{" +
                "date='" + date + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
