package com.sky.dao.vo;

import java.util.List;

/**
 * @ClassName: XSeries
 * @Description:
 * @Author: suzheng
 * @Date: 2016年04月07日
 */
public class XSeries {

    /**
     * 数据集名称，如：销售额
     */
    private String name;
    /**
     * 数据集
     */
    private List dataList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
}
