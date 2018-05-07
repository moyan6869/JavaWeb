package com.sky.common.util;

import com.sky.common.Constants;

public class CheckStrUtil {
	

	
	public static boolean checkStrFormat(String str,String index){
		if(str.lastIndexOf(index,0) !=-1 ){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 检验编辑数据
	 * 
	 * @param phone
	 * @param nickName
	 * @return
	 */
	public static boolean checkEit(String phone, String nickName) {
		if (!CheckStrUtil.checkPhone(phone)) {
			return false;
		} else if (!StringUtil.isNull(phone) && nickName.length() >= 32) {
			return false;
		}
		return true;
	}
	
	/**
	 * 验证 a-z A-Z 0-9  的 固定长数
	 * @param str
	 * @param leng
	 * @return
	 */
	public static boolean checkStr(String str,int leng){
		if(RegexUtils.checkStr(str, leng) && RegexUtils.checkNull(str)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 验证 a-z A-Z 0-9  的长度范围
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean checkStr(String str,int start,int end){
		if(str!=null){
			if(RegexUtils.checkStr(str, start,end)){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
     * 检查是否有空格  并且 验证长度
     * @param str
     * @return
     */
    public static boolean checkNull(String str){
    	return str.contains(" ");
    }
	
    
    /**
     * 检查是否数字 ，并且 长度在一个范围
     * @param num
     * @param start  
     * @param end
     * @return
     */
    public static boolean checkNum( String num,int start,int end){
    	return RegexUtils.checkNumLen(num, start,end);
    }
    
    /**
     * 检查是否数字 
     * @param num   检验的数字
     * @param leng  固定长度
     * @return
     */
    public static boolean checkNum(String num,int leng){
    	return RegexUtils.checkNumLen(num, leng);
    }
    
    /**
     * 验证 短信发送的验证码
     * @param num
     */
    public static boolean checkMsgNum(String num){
    	if(num.equals(new  Constants().AuthCode)){
    		return true;
    	}
    	return RegexUtils.checkNumLen(num, 4);
    }
    
	/**
	 * 检查手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean checkPhone( String mobile){
		if(!StringUtil.isNull(mobile)){
			mobile =mobile.length()==12?mobile.substring(0,11):mobile;
		}
		if(checkStrFormat(mobile,"00886")){
			if(mobile.length()==14){
				return true;
			}else{
				return false;
			}
		}
		return RegexUtils.checkMobile(mobile);
	}
	/**
	 * 检查手机号码后缀是否是abc
	 * @return
	 */
	public static boolean checkLowerABC( String abc){
		switch (abc){
			case "a":
				return true;
			case "b":
				return true;
			case "c":
				return true;
			default:
				return false;
		}
	}

	/**
	 * 检查用户登录名称
	 * @param str
	 * @return
	 */
	public static boolean checkLoginName( String str ){
		return RegexUtils.checkStr(str, 1, 64);
	}
	
	/**
	 * 检测 md5 获取 ID
	 * @param md5
	 * @return
	 */
	public static boolean checkMd532(String md5){
		return RegexUtils.checkStr(md5, 32);
	}

	//验证是否是邀请码
	public static boolean checkInviteCode(String username) {

		if(username.length()<11){
			return true; //小于手机号的最短限制
		}
		//如果存在超过11位的邀请码 则首先验证是否为手机号
		if(checkPhone(username.substring(0,11))){  //如果是手机号
			return false;
		}
		if(username.length()==28){
			return false;  //微信openId登录
		}
		//特殊存在的邀请码
		return true;
	}

}
