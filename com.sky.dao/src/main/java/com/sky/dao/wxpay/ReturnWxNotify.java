package com.sky.dao.wxpay;

/**
 * 微信支付异步通知微信服务器
 * @author xiaoheliu
 *
 */
public class ReturnWxNotify {
	private String return_code;
	private String return_msg;
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	
}
