package com.sky.common.util;

import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/3
 * Description:
 */
public class MessageFormatUtil {

    public static enum DateMsgFormat {
        FORMAT_SPLIT("{0}-{1}-{2}"),
        FORMAT_CN("{0}年{1}月{2}日");
        private String msgFormat;
        DateMsgFormat(String msgFormat){
            this.msgFormat = msgFormat;
        }
        public String getMsgFormat() {
            return msgFormat;
        }
    }

    public static String format(DateMsgFormat msgFormat, int year, int month, int day){
        return MessageFormat.format(msgFormat.getMsgFormat(), year, month, day);
    }

    public static String format(DateMsgFormat msgFormat, String year, String month, String day){
        return MessageFormat.format(msgFormat.getMsgFormat(), year, month, day);
    }

    public static String format(String format, Object ...args){
        return MessageFormat.format(format, args);
    }

}
