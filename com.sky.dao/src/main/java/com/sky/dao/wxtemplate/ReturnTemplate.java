package com.sky.dao.wxtemplate;

import java.io.Serializable;

public class ReturnTemplate implements Serializable  {
	private static final long serialVersionUID = 3167983375191469069L;
	
	private int errcode;
	private String errmsg;
	private int msgid;
	
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public ReturnTemplate(){}
	public ReturnTemplate(int errcode, String errmsg, int msgid) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
		this.msgid = msgid;
	}
}
