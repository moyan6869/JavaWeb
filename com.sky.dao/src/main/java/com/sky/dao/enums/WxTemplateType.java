package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/11/12.
 */
public class WxTemplateType {
	
	/**
	 * 发送模板消息的地址
	 */
	public final static String SEND_TEMPLATE_MESSAGE = "http://wechat.kangerys.com/controller/send_template_message.php";
	//public final static String SEND_TEMPLATE_MESSAGE = "http://directphp.orangebusiness.com.cn/SibuDirectSale/wxapi/send_template_message.php";
	
    /**
     * 订单支付成功通知
     */
    public final static String PAY_SUCCESS_TEMPLATE_ID = "LhbQBVqEuvc0tUf6BVwMtitPGDY9mn9Oj0CS0ipErBU";
    
    //订单支付成功的标题
    public final static String PAY_SUCCESS_FIRST = "您好，您的订单已支付成功~";
    
    public final static String PAY_SUCCESS_REMARK = "\r\n感谢您的光临~";

    /**
     * 商品退货提醒 
     */
    public final static String GOODS_PURCHASE_TEMPLATE_ID = "NmFPuH77ZpssEU7b9CGVzYzR-L_dZxW4lzMJTp5Pjo8";
    
    public final static String GOODS_PURCHASE_FIRST = "您好，您的订单已经操作退货~";
    public final static String GOODS_PURCHASE_REMARK = "\r\n如有任何疑问请与我们客服联系";

    /**
     * 收益通知
     */
    public final static String PROFIT_TEMPLATE_ID = "3aJOuaHsQ_qKhqd_FzqsG8wd7dLWesgzhwYwQp6EOgA";
    
    public final static String PROFIT_REMARK = "\r\n干得漂亮，继续加油！~";
    
    /**
     * 退款成功通知
     */
    public final static String REFUND_MONEY_TEMPLATE_ID = "TXSaay9zOL3HiQcr79VhDPyuf4AJtH16aFWcoOPhz50";
    
    public final static String REFUND_MONEY_FIRST = "退款成功通知~";
    public final static String REFUND_MONEY_REMARK = "\r\n感谢您的使用~";
    
    /**
     * 新客户加入通知
     */
    public final static String NEWCLIENT_JOIN_TEMPLATE_ID = "Z3T9XrJzRFt368NuowvYiAFty7T0SLLqCPSc5_w2QjE";
    
    public final static String NEWCLIENT_JOIN_FIRST = "您好，您有一位新的客户加入~";
    public final static String NEWCLIENT_JOIN_REMARK = "\r\n感谢您的使用~";
    
    /**
     * 订单发货通知
     */
    public final static String ORDER_DELIVERY_TEMPLATE_ID = "b11qVduMu-Zm5PPb7MSF2Mo7P_o5c-mWAm5VQYAV0iA";
    //public final static String ORDER_DELIVERY_TEMPLATE_ID = "2ufX4e-FgIB4D5pxU1MdsISb0kPeppjcMKKg8ZS1GR8";
    
    public final static String ORDER_DELIVERY_FIRST = "您好，您订购的货物已经发货了~";
    public final static String ORDER_DELIVERY_REMARK = "\r\n有任何问题请随时与我们客服联系，谢谢。";
    
    /**
     * 会员注册成功通知
     */
    public final static String MEMBER_REGISTER_TEMPLATE_ID = "UCuuS0nVRBeA8KTnJvpCY2xUkLtloOmum3yG7DXdIHU";
    
    public final static String MEMBER_REGISTER_FIRST = "恭喜您注册成为会员~";
    public final static String MEMBER_REGISTER_REMARK = "\r\n恭喜您注册成为会员，您将享受到会员所有权利！";
    
    /**
     * 升级会员
     */
    public final static String MEMBER_PROMOTION_TEMPLATE_ID = "ryKj31pPbOHFlyl9cZTj7hbJdNL1Bbo_oifXeGlurnc";
    public final static String MEMBER_PROMITION_REMARK = "\r\n祝您在康尔新零售再接再厉。";

    /**
     * 会员到期提醒
     */
    public final static String MEMBER_EXPIRE_TEMPLATE_ID = "y8bUfFz_IKRLi4QMc5z3QKlyey1JbfRba79LKa11rVU";
    public final static String MEMBER_EXPIRE_FIRST = "您好，您的会员活跃期将于%s到期。";
    public final static String MEMBER_EXPIRE_REMARK = "\r\n 有任何问题请随时与我们客服联系，谢谢。";


    /**
     * 下级会员到期提醒
     */
    public final static String SUBORDINATE_MEMBERE_EXPIRE_TEMPLATE_ID = "XxHQhCQqjSZ3n2GCupKDVfTUXAWJEc0Gwt0LKAxuueM";
    public final static String SUBORDINATE_MEMBER_EXPIRE_FIRST = "您的代理商会员活跃期即将到期，请及时提醒。";
    public final static String SUBORDINATE_MEMBER_EXPIRE_REMARK = "\r\n赶紧去通知哦。";

    /**
     * 商城首页
     */
    public final static String DIRECTSALE_HOMEPAGE = "http://wechat.kangerys.com/index.php";
    
    /**
     * 订单显示页
     */
    public final static String DIRECTSALE_ORDER_SHOW = "http://wechat.kangerys.com/controller/templateOrder.php?orderId=";
    
}
