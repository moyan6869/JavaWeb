package com.sky.common.util;

/**
 * @ClassName: ProfitTypeUtil
 * @Description:
 * @Author: suzheng
 * @Date: 2016年04月18日
 */
public class ProfitTypeUtil {
    public static String getTypeName(Integer type) {
        String typeName;
        if (null == type) {
            return "未知";
        }
        if (type == 1) {
            typeName = "推广奖";
        } else if (type == 7) {
            typeName = "月领导奖";
        } else if (type == 8) {
            typeName = "(活动)钻石支持奖";
        } else if (type == 9) {
            typeName = "(活动)金钻支持奖";
        } else if (type == 10) {
            typeName = "全球分红奖";
        } else if (type == 11) {
            typeName = "(活动)新春送温暖";
        } else {
            typeName = "未知";
        }
        return typeName;
    }
}
