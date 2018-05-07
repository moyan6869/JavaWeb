package com.sky.common.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class MsgUtil_BAK {

	private static String msgAccount = "cf_sibu";
	private static String msgPwd = "sibukanger";
	private static String msgMd5Pwd = MD5Util.MD5(msgPwd).toUpperCase();
	private static String url = "http://120.55.205.5/webservice/sms.php?method=Submit";

	/**
	 * 消息模板
	 */
	public static enum MsgTemplate {
//		CHECK_NUM_MSG("尊敬的用户：您的验证码为{0}，有效期为30分钟。"),
		CHECK_NUM_MSG("尊敬的用户：您的校验码为{0}，有效期为30分钟。"),
		FORMAT_AWARD("您好,恭喜您本月冲击{0}成功,将获得公司额外的领导奖"),
		FORMAT_UPGRADE("您好,恭喜您升级为康尔新零售{0},升级时间{1}"),
		FORMAT_ADD_MEMBER("您好,恭喜您!您的云商团队又新增了一位{0}级会员!"),
		FORMAT_BETO_MEMBER("您好!恭喜您正式成为康尔新零售{0}级会员,让我们共同开创美丽.健康.财富.自由的事业!"),
		FORMAT_DB_ERROR("数据库错误，计算进程结束"),
		FORMAT_REFUND_END("收益退款计算进程结束")	;
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
		Map<String, String> param = new  HashMap<String, String>(4);
		param.put("account", msgAccount);
		param.put("password", msgMd5Pwd);
		param.put("mobile", mobile);
		param.put("content", content);
		return  param;
	}

	public static void sendTemplateMsg(MsgTemplate msgTemplate, String phone, Object ...params) {
		String content = msgTemplate.format(params);
		Map<String, String> parm = getMsgParamMap(phone, content);
		String submitResult = "";
		Document doc = null;
		try {
			submitResult = HttpTookit.postForm(url, parm);
			System.out.println(submitResult);
			doc = DocumentHelper.parseText(submitResult);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		String msg = "";
		if(doc != null){
			Element root = doc.getRootElement();
			String code = root.elementText("code");
			msg = root.elementText("msg");
			String smsid = root.elementText("smsid");
		}
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
		sendMsg("33333","15063917180");
//		sendTemplateMsg(MsgTemplate.FORMAT_UPGRADE, "13560280810", "超级男神", "2099-12-30");
	}
}
