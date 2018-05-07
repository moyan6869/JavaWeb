package com.sky.common.util;

import javax.servlet.ServletResponse;

import com.sky.common.Constants;
import com.sky.common.massage.ResponseUtil;
import org.apache.log4j.Logger;

public class HttpUtil {

    private static Logger log = Logger.getLogger("HttpUtil");

    /**
     * 输出json格式提示
     *
     * @param response
     */
    public static void writeSuccess(ServletResponse response) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(ResponseUtil.success());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeError(ServletResponse response, String msg, Exception e) {
        log.error(e.getMessage());
        writeError(response, msg);
    }

    /**
     * 输出json格式提示
     *
     * @param response
     * @param msg      提示消息
     */
    public static void writeSuccess(ServletResponse response, String msg) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(ResponseUtil.success(msg));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出json格式提示 并且带对象消息
     *
     * @param response
     * @param msg      提示消息
     */
    public static void writeDDate(ServletResponse response, Object Objce) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(ResponseUtil.data(Objce, Constants.MSG_LOGIN));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 输出错误提示
     *
     * @param response
     */
    public static void writeError(ServletResponse response) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(ResponseUtil.error());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出错误提示
     *
     * @param response
     * @param msg      带消息传送
     */
    public static void writeError(ServletResponse response, String msg) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("utf-8");
            if(!StringUtil.isNull(msg)&& !msg.equals(Constants.MSG_LOGIN_E)){
            	response.getWriter().write(ResponseUtil.error(msg));
            }else{
            	response.getWriter().write(ResponseUtil.notLogin(msg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
