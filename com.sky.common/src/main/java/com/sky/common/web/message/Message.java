package com.sky.common.web.message;

import com.sky.common.util.JacksonUtil;

/**
 * AJAX返回信息
 * 
 * @author linwh
 *
 */
public class Message {

	private MsgType type;
	private String msg;
	private String detail;
	
	public Message(){}
	
	public Message(MsgType type, String msg){
		this.type = type;
		this.msg = msg;
	}
	
	public Message(MsgType type, String msg, String detail){
		this.type = type;
		this.msg = msg;
		this.detail = detail;
	}
	
	public String toJson(){
		
		return JacksonUtil.toJson(this);
	}
	
	/*public String toXml(){
		
		return "";
	}*/

	
	public MsgType getType() {
		return type;
	}

	public void setType(MsgType type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
