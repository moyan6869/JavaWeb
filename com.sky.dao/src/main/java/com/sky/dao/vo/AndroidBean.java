package com.sky.dao.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiyunliang on 2017/10/17.
 */
public class AndroidBean implements Serializable {
    private String cont;
    private List list1 =new ArrayList();
    private List list2 =new ArrayList();
    private List list3 =new ArrayList();
    private List list4 =new ArrayList();
    private List list5 =new ArrayList();

    public List getList1() {
        return list1;
    }

    public void setList1(List list1) {
        this.list1 = list1;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    public List getList2() {
        return list2;
    }

    public void setList2(List list2) {
        this.list2 = list2;
    }

    public List getList3() {
        return list3;
    }

    public void setList3(List list3) {
        this.list3 = list3;
    }

    public List getList4() {
        return list4;
    }

    public void setList4(List list4) {
        this.list4 = list4;
    }

    public List getList5() {
        return list5;
    }

    public void setList5(List list5) {
        this.list5 = list5;
    }
}
