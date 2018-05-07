package com.sky.dao.vo;

import org.apache.poi.ss.formula.functions.T;
import java.util.List;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/11 0011.
 */
public class PageJsonBack implements Serializable{

    private int code;
    private String memberId;
    private List<T> dataList;
    private int selfSize;
    private boolean isGoldThree ;
    private String message;
    private boolean button;

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isGoldThree() {
        return isGoldThree;
    }

    public void setGoldThree(boolean goldThree) {
        isGoldThree = goldThree;
    }

    public int getSelfSize() {
        return selfSize;
    }

    public void setSelfSize(int selfSize) {
        this.selfSize = selfSize;
    }

    public Map<String, T> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, T> dataMap) {
        this.dataMap = dataMap;
    }

    private Map<String,T> dataMap;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
