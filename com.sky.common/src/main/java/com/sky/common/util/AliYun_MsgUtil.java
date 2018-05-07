package com.sky.common.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.apache.log4j.Logger;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 最新的阿里大于短信服务支持
 * pom需要私服加载 aliyun-java-sdk-core 和aliyun-java-sdk-dysmsapi
 * create by:2017-11-22
 */
public class AliYun_MsgUtil {

    private static Logger log = Logger.getLogger(AliYun_MsgUtil.class);

    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAIRguazZ8sktRM";
    static final String accessKeySecret = "Czo9PhL4Px7Xj91FYaB7ffahjCamJd";

    //签名
    private static String SignName_KRSW="康尔生物";
    private static String SignName_XLS="康尔新零售";
    private static String SignName_YM="康尔云Mall";

    //短信模版
    //新零售用户注册验证码
    public static String Register_SMS_TemplateCode="SMS_113220038";//验证码:${code}，您正在注册成为康尔新零售用户，感谢您的支持！
    //云猫用户注册验证码
    public static String Register_SMS_TemplateCode2="SMS_113220045";//验证码${code}，您正在注册成为康尔云Mall用户，感谢您的支持！
    //发货提醒
    public static String FORMAT_EXPRESS="SMS_113210054"; //您好,您的产品已发货。快递公司：${company}, 快递单号：${number} ,有疑问请致电客服 4001856669

    //身份验证 通用
    public static String AUTH_CODE_COMMON="SMS_100975099";//验证码${code}，您正在进行身份验证，打死不要告诉别人哦！
    //新零售 验证码
    public static String Auth_SMS_TemplateCode="SMS_113215029"; // 验证码${code}，您正在进行康尔新零售会员身份验证，打死不要告诉别人哦！

    //修改会员信息 新零售会员
    public static String ChangeMsg_SMS_TemplateCode="SMS_113220039";//验证码${code}，您正在尝试变更康尔新零售会员重要信息，请妥善保管账户信息。
    //修改会员信息 康尔会员
    public static String ChangeMsg_SMS_TemplateCode2="SMS_113215027";  //验证码${code}，您正在尝试变更康尔会员重要信息，请妥善保管账户信息

    public static SendSmsResponse sendSms(String phone,String jsonStrParams,String templateCode,String sign) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(sign);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,
        request.setTemplateParam(jsonStrParams);


        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }


    public static QuerySendDetailsResponse querySendDetails(String phone,String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phone);
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }


    public static String queryDetails(String phone,SendSmsResponse response){

        StringBuffer sql=new StringBuffer();
        try {
            //查明细
            if(response.getCode() != null && response.getCode().equals("OK")) {
                QuerySendDetailsResponse querySendDetailsResponse = querySendDetails(phone,response.getBizId());
                sql.append("短信明细查询接口返回数据---------------");
                sql.append("Code=" + querySendDetailsResponse.getCode()+"; ");
                sql.append("Message=" + querySendDetailsResponse.getMessage()+"; ");
                for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs()) {
                    sql.append("Content=" + smsSendDetailDTO.getContent()+"; ");
                    sql.append("ErrCode=" + smsSendDetailDTO.getErrCode()+"; ");
                    sql.append("PhoneNum=" + smsSendDetailDTO.getPhoneNum()+"; ");
                    sql.append("SendDate=" + smsSendDetailDTO.getSendDate()+"; ");
                    sql.append("SendStatus=" + smsSendDetailDTO.getSendStatus()+"; ");
                    sql.append("Template=" + smsSendDetailDTO.getTemplateCode()+".");
                }
            }
        } catch (ClientException e) {
            e.printStackTrace();
            log.error("phone:"+phone+"--发送详情查询失败!!"+e.getCause());
        }

        return  sql.toString();
    }

    /**
     *  共用的短信发送模版
     * @param phone   手机号
     * @param jsonStrParams 参数
     * @param templateCode  模版
     * @param sign  签名
     * @return  成功与否 ok/
     */
    public static String sendTemplateMsg(String phone,String jsonStrParams,String templateCode,String sign){


        SendSmsResponse response = null;
        try {
            response = sendSms(phone,jsonStrParams,templateCode,sign);
            return response.getCode();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("phone:"+phone+" -短信发送失败!!!"+e.getCause());
        }finally {
            String detail=queryDetails(phone,response);
            log.info(detail);
            System.out.println(detail);
        }

        return "error";
    }
    /**
     *  新零售的短信发送模版  签名:康尔新零售
     * @param phone   手机号
     * @param jsonStrParams 参数
     * @param templateCode  模版
     * @return  成功与否 ok/
     */
    public static String sendTemplateMsg_XLS(String phone,String jsonStrParams,String templateCode){

        return sendTemplateMsg(phone,jsonStrParams,templateCode,SignName_XLS);
    }
    /**
     *  康尔生物的短信发送模版  签名:康尔生物
     * @param phone   手机号
     * @param jsonStrParams 参数
     * @param templateCode  模版
     * @return  成功与否 ok/
     */
    public static String sendTemplateMsg_SKY(String phone,String jsonStrParams,String templateCode){

        return sendTemplateMsg(phone,jsonStrParams,templateCode,SignName_KRSW);
    }
    /**
     *  云Mall的短信发送模版  签名:康尔云Mall
     * @param phone   手机号
     * @param jsonStrParams 参数
     * @param templateCode  模版
     * @return  成功与否 ok/
     */
    public static String sendTemplateMsg_YUN(String phone,String jsonStrParams,String templateCode){

        return sendTemplateMsg(phone,jsonStrParams,templateCode,SignName_YM);
    }

    public static void main(String[] args) throws ClientException, InterruptedException {

        //发短信
        String phone="15937237376";
        String sign=SignName_YM;
        String templateCode=AUTH_CODE_COMMON;
        String param="{'code':'1013'}";

        String res=sendTemplateMsg_YUN(phone,param,templateCode);
//        //                新版更改短信模版
//        String checkNumber="{'code':'"+StringUtil.rendomFour()+"'}";
//        String templateCode=AliYun_MsgUtil.ChangeMsg_SMS_TemplateCode;
//        AliYun_MsgUtil.sendTemplateMsg_XLS(phone,checkNumber,templateCode);
//
//        String res=AliYun_MsgUtil.sendTemplateMsg_XLS(phone,checkNumber,AliYun_MsgUtil.ChangeMsg_SMS_TemplateCode);

        System.out.println(res);



    }

    /**
     * 发送验证码
     *
     * @param phone
     */
    public void sendMsg(String phone, String smsTemplateCode) {
        String checkNumber = StringUtil.rendomFour();
        String key = SessionUtil.REDIS_MSG_PHONE + phone;
        String redisNumber = SessionUtil.getSessionCheckTime(key);
        if (!StringUtil.isNull(redisNumber)) {
            checkNumber = redisNumber;
        }

        Ali_MsgUtil.sendMsg(checkNumber, phone, smsTemplateCode);
        SessionUtil.setSessionTime(SessionUtil.REDIS_MSG_PHONE + phone,
                checkNumber);
    }


}
