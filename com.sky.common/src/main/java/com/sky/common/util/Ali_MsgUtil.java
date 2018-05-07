package com.sky.common.util;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import java.util.* ;

public class Ali_MsgUtil{


	private static String url = "http://gw.api.taobao.com/router/rest?";
	private static String method="alibaba.aliqin.fc.sms.num.send";
//	private static String appKey="23559429";
//	private static String smsFreeSignName="康尔云商";
//	private static String secret="9ab7c3b2d9dd3809496f29ddcffbe74a";
    private static String appKey="24575953";
	private static String smsFreeSignName="康尔生物";
	private static String secret="0e4475a4393975ecd5f06193a1f1cabd";
	public static String Auth_SMS_TemplateCode="SMS_32845087"; // 身份验证验证码:验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！
	public static String Login_SMS_TemplateCode="SMS_32845085";//登录确认验证码:验证码${code}，您正在登录${product}，若非本人操作，请勿泄露。
	public static String Register_SMS_TemplateCade="SMS_32845083";//用户注册验证码:验证码${code}，您正在注册成为${product}用户，感谢您的支持！
	public static String ChangePwd_SMS_TemplateCode="SMS_32845081";//修改密码：验证码${code}，您正在尝试修改${product}登录密码，请妥善保管账户信息。
	public static String ChangeMsg_SMS_TemplateCode="SMS_32845080";// 信息变更验证码:验证码${code}，您正在尝试变更${product}重要信息，请妥善保管账户信息。

	public static String MEMBER_REGISTER_SMS_TemplateCode="SMS_32825120";//您好!恭喜您正式成为${name}会员,让我们共同开创美丽.健康.财富.自由的事业!
	public static String NEWCLIENT_JOIN_SMS_TemplateCode="SMS_32910142";//您好,恭喜您!您的云微商团队又新增了一位${name}会员!
	public static String Up_Member_SMS_TemplateCode="SMS_32790074";//您好,恭喜您升级为${name},升级时间${date}
	public static String CHONGJI_SUCESS_SMS_TemplateCode="SMS_32870063";//您好,恭喜您本月冲击${name}成功,将获得${product}额外的领导奖!

	public static Map<String, String> getMsgParamMap(String smsFreeSignName,String jsonStrParams, String mobile, String smsTemplateCode){
		Map<String, String> param = new  HashMap<String, String>();
		param.put("method", method);
		param.put("app_key",appKey);
		param.put("timestamp", DateUtil.getCurrDateStr("yyyy-MM-dd HH:mm:ss"));
		param.put("format", "json");
		param.put("v", "2.0");
		param.put("simplify","true");
		param.put("sign_method", "md5");
		param.put("sms_type","normal");
		param.put("sms_free_sign_name",smsFreeSignName);
		param.put("sms_param",jsonStrParams);
		param.put("rec_num",mobile);
		param.put("sms_template_code", smsTemplateCode);
		return  param;
	}

	public static void sendTemplateMsg(String phone,String jsonStrParams,String templateCode) {
		try {

			TaobaoClient client = new DefaultTaobaoClient(url, appKey,secret);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend("extend");
			req.setSmsType("normal");  //短信类型
			req.setSmsFreeSignName(smsFreeSignName);
			req.setSmsParamString(jsonStrParams);// "{'name':'Geoffrey'}"
			req.setRecNum(phone);
			req.setSmsTemplateCode(templateCode);//"SMS_12630322"
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送验证短信
	 * @param checkNumber
	 * @param phone
	 */
	public static void sendMsg(String checkNumber, String phone,String smsTemplateCode) {
		sendTemplateMsg(phone,"{'code':'"+checkNumber+"','product':'康尔新零售'}",smsTemplateCode);
	}

	public static void main( String[] args ){
//		13408577235

//		sendTemplateMsg("您好！", "13560280810","");
//		sendTemplateMsg( "15626204068", "{'code':'20460725','product':'康尔新零售'}",Ali_MsgUtil.Auth_SMS_TemplateCode);
//		sendTemplateMsg(MsgTemplate.FORMAT_UPGRADE, "13560280810", "超级男神", "2099-12-30");
	}
}
