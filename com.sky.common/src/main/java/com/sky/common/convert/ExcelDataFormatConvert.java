package com.sky.common.convert;

import com.sky.common.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.common.convert
 * @company: SI Bu kanger
 * @Description: excel数据导出转换类
 * @date 2016/5/9
 */
public class ExcelDataFormatConvert {

    public static ExcelDataFormatConvert INSTANCE = new ExcelDataFormatConvert();


    public String formatDate(Date date, String format) {
        if (null != date && StringUtils.isNotBlank(format)) {
            return DateUtil.convertDateToStr(date, format);
        }
        return null;
    }

    public String remove(String str, String target) {
       return StringUtils.remove(str, target);
    }

    public String convertExpressStatus(final int expressStatus) {
        switch (expressStatus) {
            case 1:
               return " 已通知快递";
               
            case 2:
                return " 快递已揽收";
               
            case 3:
                return " 快递运输中";
               
            case 4:
                return " 已到目的地";
               
            case 5:
                return " 正在派件";
               
            case 6:
                return " 已签收";
               
            case 7:
                return " 收件人拒收";
            default:
                return "";
        }
    }
}
