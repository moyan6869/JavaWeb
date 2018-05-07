package com.sky.dao.wxtemplate;

import java.util.Map;

public class MsgTemplate {
	//模板消息的id
	private String template_id;
	//模板消息要发送的人
	private String touser;
	//签名（appid+touser）
	private String signature;
	//模板消息头部颜色
	private String topcolor;
	//模板消息点击跳转的连接
	private String url;
	//模板消息主题内容
	private Map<String, TemplateData> data;
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, TemplateData> getData() {
		return data;
	}
	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}
	
}
