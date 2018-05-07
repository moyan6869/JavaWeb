package com.sky.common.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.common.util
 * @company: SI Bu kanger
 * @Description: 数字金额格式化工具类
 * @date 2016/3/28
 */
public class NumberFormatUtil {

    public static final NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(Locale.CHINA);
    public static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.CHINA);
    public static final NumberFormat PERCENT_FORMAT = NumberFormat.getPercentInstance(Locale.CHINA);
    public static final BigDecimal BASE_NUMBER = BigDecimal.valueOf(100);
    public static final String CNY_PRE_FIX = "￥";
    public static final String BLANK = "";

    /**
     * 整形数字格式化，三位一个逗号分隔
     * @return
     */
    public static String numberToString(Object obj){
        return NUMBER_FORMAT.format(obj);
    }

    /**
     * 分为单位的金额格式化
     * @return
     */
    public static String currencyToString(String currency){
        return CURRENCY_FORMAT.format(new BigDecimal(currency).divide(BASE_NUMBER)).replace(CNY_PRE_FIX,BLANK);
    }

    /**
     * 分为单位的金额格式化
     * @return
     */
    public static String convertLongToString(Long currency){
        return CURRENCY_FORMAT.format(new BigDecimal(currency).divide(BASE_NUMBER)).replace(CNY_PRE_FIX,BLANK);
    }
    /**
     * 分为单位的金额格式化
     * @return
     */
    public static String convertIntegerToString(Integer currency){
        return CURRENCY_FORMAT.format(new BigDecimal(currency).divide(BASE_NUMBER)).replace(CNY_PRE_FIX,BLANK);
    }

    /**
     * 传入分子分母，返回百分比
     * @param molecule
     * @param denominator
     * @return
     */
    public static String pointToPercent(BigDecimal molecule,BigDecimal denominator){
        PERCENT_FORMAT.setMinimumFractionDigits(2);
        return PERCENT_FORMAT.format(molecule.divide(denominator,10,BigDecimal.ROUND_HALF_DOWN));
    }

    public static String pointToPercent(Object obj){
        return PERCENT_FORMAT.format(obj);
    }
}
