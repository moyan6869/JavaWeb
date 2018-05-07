package com.sky.dao.wxpay;

/**
 * 功能：微信支付异步通知实体类
 * 应用：支付完成后，微信会把相关支付结果和用户信息发送给商户，商户需要接收处理，并返回应答。
     对后台通知交互时，如果微信收到商户的应答不是成功或超时，微信认为通知失败，
     微信会通过一定的策略（如30分钟共8次）定期重新发起通知，尽可能提高通知的成功率，
     但微信不保证通知最终能成功。 （通知频率为15/15/30/180/1800/1800/1800/1800/3600，单位：秒）
 * @author xiaoheliu
 *
 */
public class WxpayNotify {
	
	private String appid; //公众账号ID
	private String attach; //商家数据包
	private String bank_type; //付款银行
	private String fee_type; //货币种类
	private String is_subscribe; //是否关注公众账号
	private String mch_id; //商户号
	private String nonce_str; //随机字符串
	private String openid; //用户标识
	private String out_trade_no; //商户订单号
	private String result_code; //业务结果
	private String return_code; //返回状态码
	private String sign; //签名
	private String sub_mch_id; //
	private String time_end; //支付完成时间
	private String total_fee; //总金额
	private String trade_type; //交易类型
	private String transaction_id; //微信支付订单号
	private String cash_fee;
	
	public String getcash_fee() {
		return cash_fee;
	}
	public void setcash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getappid() {
		return appid;
	}
	public void setappid(String appid) {
		this.appid = appid;
	}
	public String getattach() {
		return attach;
	}
	public void setattach(String attach) {
		this.attach = attach;
	}
	public String getbank_type() {
		return bank_type;
	}
	public void setbank_type(String bank_type) {
		this.bank_type = bank_type;
	}
	public String getfee_type() {
		return fee_type;
	}
	public void setfee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getis_subscribe() {
		return is_subscribe;
	}
	public void setis_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
	public String getmch_id() {
		return mch_id;
	}
	public void setmch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getnonce_str() {
		return nonce_str;
	}
	public void setnonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getopenid() {
		return openid;
	}
	public void setopenid(String openid) {
		this.openid = openid;
	}
	public String getout_trade_no() {
		return out_trade_no;
	}
	public void setout_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getresult_code() {
		return result_code;
	}
	public void setresult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getreturn_code() {
		return return_code;
	}
	public void setreturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getsign() {
		return sign;
	}
	public void setsign(String sign) {
		this.sign = sign;
	}
	public String getsub_mch_id() {
		return sub_mch_id;
	}
	public void setsub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}
	public String gettime_end() {
		return time_end;
	}
	public void settime_end(String time_end) {
		this.time_end = time_end;
	}
	public String gettotal_fee() {
		return total_fee;
	}
	public void settotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String gettrade_type() {
		return trade_type;
	}
	public void settrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String gettransaction_id() {
		return transaction_id;
	}
	public void settransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	@Override
	public String toString() {
		return "WxpayNotify [appid=" + appid + ", attach=" + attach
				+ ", bank_type=" + bank_type + ", fee_type=" + fee_type
				+ ", is_subscribe=" + is_subscribe + ", mch_id=" + mch_id
				+ ", nonce_str=" + nonce_str + ", openid=" + openid
				+ ", out_trade_no=" + out_trade_no + ", result_code="
				+ result_code + ", return_code=" + return_code + ", sign="
				+ sign + ", sub_mch_id=" + sub_mch_id + ", time_end="
				+ time_end + ", total_fee=" + total_fee + ", trade_type="
				+ trade_type + ", transaction_id=" + transaction_id + "]";
	}
	
}
