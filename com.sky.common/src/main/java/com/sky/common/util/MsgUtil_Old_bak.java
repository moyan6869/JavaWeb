package com.sky.common.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class MsgUtil_Old_bak {

	private static String SN = "SDK-BBX-010-20982";
	private static String PWD = "7c7-e630";
	private static String pwd = MD5Util.MD5(SN+PWD).toUpperCase();
	private static String url = "http://sdk2.entinfo.cn:8061/webservice.asmx/mdsmssend";

	/**
	 * 消息模板
	 */
	public static enum MsgTemplate {
		CHECK_NUM_MSG("【康尔新零售】尊敬的用户：您的验证码为{0}，有效期为30分钟。"),
		FORMAT_AWARD("【康尔新零售】您好,恭喜您本月冲击{0}成功,将获得公司额外的领导奖"),
		FORMAT_UPGRADE("【康尔新零售】您好,恭喜您升级为康尔新零售{0},升级时间{1}"),
		FORMAT_ADD_MEMBER("【康尔新零售】您好,恭喜您!您的云微商团队又新增了一位{0}级会员!"),
		FORMAT_BETO_MEMBER("【康尔新零售】您好!恭喜您正式成为康尔新零售{0}级会员,让我们共同开创美丽.健康.财富.自由的事业!"),
		FORMAT_DB_ERROR("【康尔新零售】数据库错误，计算进程结束"),
		FORMAT_REFUND_END("【康尔新零售】收益退款计算进程结束")	;
		private String msgFormat;
		MsgTemplate(String msgFormat){
			this.msgFormat = msgFormat;
		}
		public String getMsgFormat() {
			return msgFormat;
		}

		public String format(Object ...params){
			return MessageFormat.format(this.getMsgFormat(), params);
		}
	}

	private static Map<String, String> getMsgParamMap(String mobile, String content){
		Map<String, String> param = new  HashMap<String, String>(8);
		param.put("sn", SN);
		param.put("pwd", pwd);
		param.put("ext", "8");
		param.put("stime", "");
		param.put("rrid", "");
		param.put("msgfmt", "");
		param.put("mobile", mobile);
		param.put("content", content);
		return  param;
	}

	public static void sendTemplateMsg(MsgTemplate msgTemplate, String phone, Object ...params) {
		String content = msgTemplate.format(params);
		Map<String, String> parm = getMsgParamMap(phone, content);
		String submitResult = "";
		try {
			submitResult = HttpTookit.postForm(url, parm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(submitResult);
	}

	/**
	 * 发送验证短信
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendMsg(String checkNumber, String phone) {
		sendTemplateMsg(MsgTemplate.CHECK_NUM_MSG, phone, checkNumber);
	}

	public static void main( String[] args ){
//		13408577235
		sendMsg("33333","13560280810");
//		sendTemplateMsg(MsgTemplate.FORMAT_UPGRADE, "13560280810", "超级男神", "2099-12-30");
	}
}
