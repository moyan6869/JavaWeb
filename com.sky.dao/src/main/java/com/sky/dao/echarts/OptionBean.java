package com.sky.dao.echarts;


import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */
public class OptionBean {

    private Legend legend;
    private XAxis xAxis;
    private List<Series> series;

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    public OptionBean(Legend legend, XAxis xAxis, List<Series> series) {
        this.legend = legend;
        this.xAxis = xAxis;
        this.series = series;
    }

    public OptionBean(Legend legend) {
        this.legend = legend;
    }

    public OptionBean() {
    }

    public static void main(String[] args) {

        OptionBean optionBean = new OptionBean();
    }

}
