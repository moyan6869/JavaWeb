package com.sky.common.piting;

import java.util.List;

public class Pager<T> {
    private boolean flag = false; //true表示可以进行金三角安置
    private List<T> datas;
    private int pageOffset; //当前的页数
    private int pageSize; //一页显示多少条
    private long totalRecord; //总记录数
    private int totalPage; //总页数
    private Object ex = new NullObjectBean();//扩展字段

    public Object getZs() {
        return zs;
    }

    public void setZs(Object zs) {
        this.zs = zs;
    }

    private Object zs = new NullObjectBean();//扩展字段


    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {

        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalRecord) {
        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = (totalRecord / pageSize) + 1;
        }
    }

    public Object getEx() {
        return ex;
    }

    public void setEx(Object ex) {
        this.ex = ex;
    }
}