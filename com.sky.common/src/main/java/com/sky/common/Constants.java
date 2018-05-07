package com.sky.common;

import com.sky.common.util.SessionUtil;
import com.sky.common.util.SpringValuesUtil;
import com.sky.common.util.StringUtil;

public class Constants {
	/**
	 * 资源文件路径
	 */
	public final static String LOCATION = "applicationContext.xml";
	public final static int LIMIT_DAY = -23; //奖金币下单限制天数
	public static String DEFAULT_DATA_SOURCE_NAME="dataSource";
//	public static final String USER_HEAD_IMAGE="http://120.25.63.159:8080/";
//public static final String API_HTTP_HEAD = "http://api.kangerys.com/api/";
	public static  String API_HTTP_HEAD = SpringValuesUtil.getValue("appHttpHead");
	public static final String MSG_LOGIN = "恭喜您，登陆成功！";
	public static final String MSG_LOGIN_E = "请先登录！";
	public static final String MSG_LOGIN_E_U = "密码输入错误！";
	public static final String MSG_LOGIN_ESG = "数据出错！";
	public static final String MGS_BIDING = "绑定成功!";
	public static final String PRE_KEY="ODO_";
	// 微信前缀 redis 保存
	public static final String REDIS_OPEN_ID = "openid_";
	// 手机前缀 redis 保存
	public static final String REDIS_PHONE = "phone_";
	// 邀请码 redis 保存
	public static final String REDIS_INVITA = "invita_";
	public static final String REDIS_INVITA_FORMAT = "invita_{0}";//邀请码
	// 用户点击量 redis 保存
	public static final String REDIS_USER_CLICK_COUNT = "user_click_count:";
	// 用户意向量 redis 保存
	public static final String REDIS_INTENTION_COUNT = "intention_count:";
	// 用户二维码redis 保存
	public static final String REDIS_USER_EQCODE = "user_eqcode:";
	// 随机 上级 发送邀请码 redis 保存
	public static final String REDIS_REFE_INVITA = "ref_invita:";
	// member redis 保存
	public static final String REDIS_MEMBER = "";


	// FOOD_WARE_HOUSE redis 保存
	public static final String REDIS_FOOD_WARE_HOUSE = "";

	// 登录前缀 (用于 odoshop 康尔绿厨  自提点 )
	public static final String SHIRO_LOGIN = "login_user:";
	//会员未读消息数量
	public static final String MEMBER_MESSAGE_NO_READ_COUNT="messageCount:";
	//临时邀请码前缀 redis 保存
	public static final String LT_REDIS_INVITA="ltvita_";

	public static final String MEMBER_QRCODE_URL="memberQrCodeUrl:";
	//各会员级别对应的金额  单位:分
	public final static int MONEY_GOLD= 1500*100; // 金卡

	public final static int MONEY_GOLD_HK= 2000*100; // 金卡(海葵专属)


	public final static int MONEY_WHITE = 7500*100; // 白金卡


	public final static int MONEY_CROWN = 15000*100; // 钻卡


	public final static int MONEY_GOLD_UP_WHITE = 6000*100; // 金卡升级白金卡

	public final static int MONEY_GOLD_UP_WHITE_HK = 5500*100; // 金卡升级白金卡(海葵专属)


	public final static int MONEY_WHITE_UP_CROWN = 7500*100; // 白金卡升级钻卡


	public final static int MONEY_GOLD_UP_CROWN = 13500*100; // 金卡升级钻卡

	public final static int MONEY_GOLD_UP_CROWN_HK = 13000*100; // 金卡升级钻卡(海葵专属)
	//
	//
	//
	public final static int MONEY_GOLD_ZH= 2000*100; // 金卡(正弘专属)
	public final static int MONEY_WHITE_ZH = 10000*100; // 白金卡(正弘专属)
	public final static int MONEY_CROWN_ZH = 20000*100; // 钻卡(正弘专属)
	public final static int MONEY_GOLD_UP_WHITE_ZH = 8000*100; // 金卡升级白金卡(正弘专属)
	public final static int MONEY_WHITE_UP_CROWN_ZH = 10000*100; // 白金卡升级钻卡(正弘专属)
	public final static int MONEY_GOLD_UP_CROWN_ZH= 18000*100; // 金卡升级钻卡(正弘专属)

	public static final String ZHHINT="尊敬的用户,您当前订单所购买的注册套餐数量超出购买限制,请重新下单";//正弘特殊产品的描述
	public final static int ZH_GOLD= 1; // 金卡标识(正弘专属)
	public final static int ZH_WHITE = 2; // 白金卡(正弘专属)
	public final static int ZH_CROWN = 3; // 钻卡(正弘专属)


	/**
	 *
	 *艾绒产品常量
	 */

	public static final String ARPRODUCT_ID_A="582444851c564b5cb8d1fa95d11d394a";//肺部养生
	public static final String ARPRODUCT_ID_B="65c45020a413419bb45ce20b8774c90f";//暖宫养生
	public static final String ARPRODUCT_ID_C="7356fe04f0ce402baf8464a71dab8af5";//脾胃养生
	public static final String ARPRODUCT_ID_D="8a2f9bbc0e9548cf81663713bdf1ceee";//舒肝养生
	public static final String ARPRODUCT_ID_E="dd3d0b6478d04c6d87a14ee5fb868e34";//固肾养生
	//	无拨比产品
	public static final String ARPRODUCT_ID_H="1d4f9ce5dc3a480b945d67cc1435164a";//1600养生仪(特惠)
	//public static final String ARPRODUCT_ID_G="d34785ba445a4298ad8249796070e1ad";

	public final static int ARPRODUCT_COUNT_ZC= 3; // 注册单艾灸仪产品购买资格所需的产品数量
	public final static int ARPRODUCT_COUNT_LS= 5; // 零售单艾灸仪产品购买资格所需的产品数量





	/**
	 * wangguofeng 2017-11-23 修改  由com.sky.api.Constants
	 * 包运费常量
	 */
	public static final int BAOYOU_MONEY = 75000;//750元，返回分
	/**
	 * 数量类型字段无数据
	 */
	public static final int NO_DATA_NUM=0;
	/**
	 * 字符类型字段无数据
	 */
	public static final String NO_DATA_CHAR="";
	/**
	 * 结算平台，一个订单可以影响到的收益级数
	 */
	public static final int PROFIT_LEVEL=9;
	/**
	 * 降序
	 */
	public static final String SORT_DESC="desc";
	/**
	 * 升序
	 */
	public static final String SORT_ASC="asc";

	/*永骏仓库编码*/
	public static final String FW_YJ_Care_Code="YJ001";

	/*防伪码信息*/
	public static final String FW_CODE="fw_code:";

	/*防伪码信息*/
	public static final String FW_CODE_COUNT="fw_code_count:";


	//课程点赞信息
	public static final String COURSE_LIKE="course_like:";
	//会员签到记录
	public static final String MEMBER_SIGN_IN="member_sign_in:";

	//万能验证码存储
	public static final String AUTH_CODE ="authCode:";

	public static String YUN_IPADDRESS = "http:127.0.0.1:8080/odoweb";

    /*万能验证码*/
	public   String AuthCode=getAuthCode();

	 String getAuthCode(){ return StringUtil.isNull(SessionUtil.getSessionString(AUTH_CODE))? "20160920": SessionUtil.getSessionString(AUTH_CODE);}


	public static final String Member_Draw_Available_Num="memberDrawAvailableNum:";

	public static final  String Spring_Festival_Order="SpringFestivalOrder:";

	/*会员可用抽奖次数*/

 	public 	int	getMemberDrawAvailableNum(){
		long num= SessionUtil.getSessionLongValue(Member_Draw_Available_Num);
		if (StringUtil.isNull(num+"")||num==0){
			return 5;
		}
		return StringUtil.getInt(num);	}

	//物流公司名称    佳怡供应链企业集团
	public static final String WMS_NAME="Joyi.com";
 	//物流公司编码
	public static final String WMS_CODE="odo";

	//物流接口编码（批量获取销售出库单回传信息）
	public static final String WMS_OUT_ORDER_MSG_TRANSMISSION="WMS_OUT_ORDER_MSG_TRANSMISSION";

	//物流接口编码（批量获取销售出库单）
	public static final String WMS_OUT_ORDER_MSG_SALES="WMS_OUT_ORDER_MSG_SALES";

	//物流接口URI地址（批量获取销售出库单回传信息）
	public static final String WMS_OUT_ORDER_URI = "http://221.214.90.154:9098/Webservice/Joyi.asmx?op=WMS_OUT_ORDER_MSG_TRANSMISSION";



}
