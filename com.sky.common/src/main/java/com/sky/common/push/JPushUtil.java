package com.sky.common.push;

import java.util.HashMap;
import java.util.Map;

import com.sky.common.util.SpringValuesUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.sky.dao.enums.JPushType;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.examples.PushExample;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtil {

	private static Logger log = Logger.getLogger(PushExample.class);
	private static final String appKey ="fa2b6be6e8ed8b653ff30966";
	private static final String masterSecret = "cc1637782d7fa5a8b428d843";
	@Value("${apple_push}")
	private Boolean applePush;
	public static void main( String[] args ){
		SendPush("43920da2e8854de082b75944cbf89a0c", "标题",3,"3333");
	}


	/**
	 * 推送
	 * @Title: SendPush
	 * @Description: TODO
	 * @param @param memberId   memberId
	 * @param @param alert      弹出内容
	 * @param @param typeId	         推送类型
	 * @param @param extrastr   类型Id
	 * @return void
	 * @throws
	 */
	public static void SendPush(String memberId, String alert,int typeId,String ids) {
		Map<String,String> extras = new HashMap<String,String>();
		extras.put("title", JPushType.valueOf(typeId).getMsg());
		extras.put("type", typeId+"");
		extras.put("ids", ids);
		String masterSecret = SpringValuesUtil.getValue("jpush_masterSecret");
		String appKey = SpringValuesUtil.getValue("jpush_appkey");
		JPushClient jpushClient = new JPushClient( masterSecret,appKey);
		String applePush = SpringValuesUtil.getValue("apple_push");
		boolean applePushBoolean = Boolean.parseBoolean(applePush);
		if (applePushBoolean) {//如果是生产配置，则两套环境都推送
//        JPushClient jpushClient = new JPushClient(masterSecret,appKey);
			sendPush(memberId, alert, extras, jpushClient, true);
		}
		sendPush(memberId, alert, extras, jpushClient, false);
	}

	private static void sendPush(String memberId, String alert, Map<String, String> extras, JPushClient jpushClient, boolean applePushBoolean) {
		PushPayload payload = buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(memberId,alert,extras,applePushBoolean);
		try {
			PushResult result = jpushClient.sendPush(payload);
			//log.error(memberId+" "+alert);
			log.warn("jpush - " + memberId+" "+alert);
		} catch (APIConnectionException e) {
			log.error(memberId+" "+alert);
			log.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			log.error(memberId+" "+alert);
			log.error("Error response from JPush server. Should review and fix it. ", e);
			log.info("HTTP Status: " + e.getStatus());
			log.info("Error Code: " + e.getErrorCode());
			log.info("Error Message: " + e.getErrorMessage());
			log.info("Msg ID: " + e.getMsgId());
		}
	}

	/**
	 *
	 * @Title: buildPushObject_ios_tagAnd_alertWithExtrasAndMessage
	 * @Description: TODO
	 * @param @param memberId
	 * @param @param alert
	 * @param @param extras
	 * @param @param applePush   真 是推送到苹果生产环境  假 推送到测试环境
	 * @param @return
	 * @return PushPayload
	 * @throws
	 */
	private static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(String memberId, String alert, Map<String, String> extras,boolean applePush) {
		long sceng = 1L;
		return PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag(memberId))
				.setNotification(Notification.newBuilder()
						.setAlert(alert)
						.addPlatformNotification(AndroidNotification.newBuilder().
								addExtras(extras).build())
						.addPlatformNotification(IosNotification.newBuilder()
								.incrBadge(1)
								.addExtras(extras).build())
						.build()).setOptions(Options.newBuilder().setApnsProduction(applePush)
						.build())
				.build();

	}
}
