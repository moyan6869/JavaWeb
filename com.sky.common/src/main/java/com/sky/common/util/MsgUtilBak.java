package com.sky.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MsgUtilBak {
			
	public static void main( String[] args ){
//		13408577235
		sendText("系统内测提示","13607256166");
	}
	
	/**
	 * 发送验证短信
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendMsg1(String checkNumber,String phone){
		String SN = "SDK-BBX-010-20982";
		String PWD = "7c7-e630";
		String pwd = MD5Util.MD5(SN+PWD).toUpperCase();
		 Map<String, String> parm = new  HashMap<String, String>();
		 String msg="";
		try {
			parm.put("sn", SN);
			parm.put("pwd", pwd);
			parm.put("mobile",phone);
			parm.put("content", "【康尔新零售】您好，祝贺您成为康尔云商金钻代理");
			parm.put("ext", "8");
			parm.put("stime", "");
			parm.put("rrid", "");
			parm.put("msgfmt", "");
			msg= HttpTookit.postForm("http://sdk2.entinfo.cn:8061/webservice.asmx/mdsmssend",parm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}
	
	/**
	 * 发送验证短信
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendMsg(String checkNumber,String phone){
		String SN = "SDK-BBX-010-20982";
		String PWD = "7c7-e630";
		String pwd = MD5Util.MD5(SN+PWD).toUpperCase();
		 Map<String, String> parm = new  HashMap<String, String>();
		 String msg="";
		try {
			parm.put("sn", SN);
			parm.put("pwd", pwd);
			parm.put("mobile",phone);
			parm.put("content", "【康尔新零售】尊敬的用户：您的验证码为"+checkNumber+"。有效期为30分钟");
			parm.put("ext", "8");
			parm.put("stime", "");
			parm.put("rrid", "");
			parm.put("msgfmt", "");
			msg= HttpTookit.postForm("http://sdk2.entinfo.cn:8061/webservice.asmx/mdsmssend",parm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}
	
	/**
	 * 发送密码
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendPass(String checkNumber,String phone){
		String SN = "SDK-BBX-010-20982";
		String PWD = "7c7-e630";
		String pwd = MD5Util.MD5(SN+PWD).toUpperCase();
		 Map<String, String> parm = new  HashMap<String, String>();
		 String msg="";
		try {
			parm.put("sn", SN);
			parm.put("pwd", pwd);
			parm.put("mobile",phone);
			parm.put("content", "【康尔新零售】尊敬的用户：您的密码为:"+checkNumber+"。请及时更改");
			parm.put("ext", "8");
			parm.put("stime", "");
			parm.put("rrid", "");
			parm.put("msgfmt", "");
			msg= HttpTookit.postForm("http://sdk2.entinfo.cn:8061/webservice.asmx/mdsmssend",parm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
	}
	/**
	 * 发送通知
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendText(String text,String phone){
		String SN = "SDK-BBX-010-20982";
		String PWD = "7c7-e630";
		String pwd = MD5Util.MD5(SN+PWD).toUpperCase();
		 Map<String, String> parm = new  HashMap<String, String>();
		 String msg="";
		
		try {
			parm.put("sn", SN);
			parm.put("pwd", pwd);
			parm.put("mobile",phone);
			parm.put("content", "【康尔新零售】"+text);
			parm.put("ext", "8");
			parm.put("stime", "");
			parm.put("rrid", "");
			parm.put("msgfmt", "");
			msg= HttpTookit.postForm("http://sdk2.entinfo.cn:8061/webservice.asmx/mdsmssend",parm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(msg);
		
	}
}
