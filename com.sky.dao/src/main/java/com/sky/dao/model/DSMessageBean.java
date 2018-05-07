package com.sky.dao.model;

import java.io.Serializable;
import java.util.Date;

public class DSMessageBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -235076388826213826L;
	private int type; // type 类型  0:停止服务, 1：app消息，2 短信，3 微信
	private String phone; // 手机号码
	private String memberId; // app消息 需传递 memberid
	private int jPushType; // app 推送 jpush 类型
	private String content; // 内容
	private Date createTime; // 消息产生时间
	private String ids ; // ids
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getjPushType() {
		return jPushType;
	}

	public void setjPushType(int jPushType) {
		this.jPushType = jPushType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DSMessageBean [type=" + type + ", phone=" + phone + ", memberId=" + memberId + ", jPushType="
				+ jPushType + ", content=" + content + ", createTime=" + createTime + ", ids=" + ids + "]";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
