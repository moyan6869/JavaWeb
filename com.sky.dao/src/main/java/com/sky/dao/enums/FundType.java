package com.sky.dao.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 基金类型（豪车基金;旅游基金）
 * Created by Administrator on 2015/10/22.
 */
public enum FundType {
    /**
     *
     */
    All(0, "全部"),
    /**
     * 豪车基金
     */
    CarFund(1, "豪车基金"),
    /**
     *旅游基金
     */
    TripFund(2, "旅游基金");
    private int code; //代码
    private String desc; //描述

    /**
     * enum lookup map
     */
    private static final Map<Integer, String> fundTypeMap = new HashMap<Integer, String>();

    static {
        for (FundType s : EnumSet.allOf(FundType.class)) {
           if(!s.equals(All)){
               fundTypeMap.put(s.getCode(), s.getDesc());
           }

        }
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private FundType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> getFundTypeMap() {
        return fundTypeMap;
    }
    public static FundType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return CarFund;
            case 2:
                return TripFund;
            default:
                return All;
        }
    }
}
