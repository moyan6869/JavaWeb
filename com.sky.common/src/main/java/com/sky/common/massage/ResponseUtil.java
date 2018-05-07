package com.sky.common.massage;

import com.sky.common.util.JacksonUtil;
import com.sky.common.util.StringUtil;

/**
 * 用于生成接口调用响应消息体
 *
 * @author linwh
 */
public class ResponseUtil {

	public static final String SUCCESS="success";
	
    /**
     * 请求成功，返回数据消息
     *
     * @param object 数据
     * @return
     */
    public static String data(Object object) {

    	if(StringUtil.isNull(object)){
    		BaseResponse resp = new BaseResponse(Status.SUCCESS,SUCCESS);
    		return JacksonUtil.toJson(resp);
    	}else{
    		DataResponse resp = new DataResponse(Status.SUCCESS, SUCCESS, object);
    		return JacksonUtil.toJson(resp);
    	}
    }

    /**
     * 请求成功，返回数据消息
     *
     * @param object 数据
     * @return
     */
    public static String dataAA(Object object) {

        if(StringUtil.isNull(object)){
            DataResponse resp = new DataResponse(Status.SUCCESS,SUCCESS,null);
            return JacksonUtil.toJson(resp);
        }else{
            DataResponse resp = new DataResponse(Status.SUCCESS, SUCCESS, object);
            return JacksonUtil.toJson(resp);
        }
    }


    /**
     * 请求成功，返回数据消息
     *
     * @param object 数据
     * @return
     */
    public static String data(Object object, String msg) {
    	if(StringUtil.isNull(msg))
    		msg=SUCCESS;
    	if(StringUtil.isNull(object)){
    		BaseResponse resp = new BaseResponse(Status.SUCCESS,msg);
    		return JacksonUtil.toJson(resp);
    	}else{
    		DataResponse resp = new DataResponse(Status.SUCCESS, msg, object);
    		return JacksonUtil.toJson(resp);
    	}

    }
    
    

    /**
     * 请求成功
     */
    public static String success() {
    	BaseResponse resp = new BaseResponse(Status.SUCCESS,"success");

        return JacksonUtil.toJson(resp);
    }
    
    /**
     * 请求成功，并且返回	
     * @param msg	 消息提示
     * @param code   返回的状态吗
     * @return
     */
    public static String success(String msg,int code) {
    	BaseResponse resp = new BaseResponse(code,msg);
        return JacksonUtil.toJson(resp);
    }

    /**
     * 请求成功带参数提示
     *
     * @param msg
     * @return
     */
    public static String success(String msg) {
    	BaseResponse resp = new BaseResponse(Status.SUCCESS,msg);
        return JacksonUtil.toJson(resp);
    }

    /**
     * 请求出错
     *
     * @return
     */
    public static String notLogin(String msg) {

    	BaseResponse resp = new BaseResponse(Status.NotLogin, msg);

        return JacksonUtil.toJson(resp);
    }

    /**
     * 请求出错
     *
     * @return
     */
    public static String error() {

    	BaseResponse resp = new BaseResponse(Status.OtherError, "Error");

        return JacksonUtil.toJson(resp);
    }
    /**
     * 请求出错(自定义code)
     *
     * @return
     */
    public static String error(int code,String msg) {

        BaseResponse resp = new BaseResponse(code, msg);

        return JacksonUtil.toJson(resp);
    }

    /**
     * 请求出错，返回错误消息
     *
     * @param msg 消息内容
     * @return
     */
    public static String error(String msg) {

    	BaseResponse resp = new BaseResponse(Status.OtherError, msg);
        return JacksonUtil.toJson(resp);
    }

    private static final String unkownVersion = "未知版本号";

    /**
     * 版本号错误
     *
     * @return
     */
    public static String unknownVersion() {
    	BaseResponse resp = new BaseResponse(Status.OtherError, unkownVersion);

        return JacksonUtil.toJson(resp);
    }

    //用户生成临时邀请码的特殊json返回
    public static String Invitdata(int type,String msg,Object object)
    {
        DataResponse resp = new DataResponse(type, msg, object);
        return JacksonUtil.toJson(resp);
    }
}
