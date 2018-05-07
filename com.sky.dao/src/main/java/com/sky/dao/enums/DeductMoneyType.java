package com.sky.dao.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 扣款类型（扣收益;扣余额）
 * Created by Administrator on 2015/10/22.
 */
public enum DeductMoneyType {
    /**
     *
     */
    All(0, "全部"),
    /**
     * 扣收益
     */
    DeductProfit(1, "扣收益"),
    /**
     *扣余额
     */
    DeductAvailable(2, "扣余额");
    private int code; //代码
    private String desc; //描述

    /**
     * enum lookup map
     */
    private static final Map<Integer, String> deductMoneyTypeMap = new HashMap<Integer, String>();

    static {
        for (DeductMoneyType s : EnumSet.allOf(DeductMoneyType.class)) {
           if(!s.equals(All)){
               deductMoneyTypeMap.put(s.getCode(), s.getDesc());
           }

        }
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private DeductMoneyType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> getDeductMoneyTypeMap() {
        return deductMoneyTypeMap;
    }
    public static DeductMoneyType valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return DeductProfit;
            case 2:
                return DeductAvailable;
            default:
                return All;
        }
    }
}
