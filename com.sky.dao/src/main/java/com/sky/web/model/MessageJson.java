package com.sky.web.model;

import java.util.List;

public class MessageJson {
	private int code;
	private String message;
	private List data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public MessageJson() {
		super();
	}
	public MessageJson(int code, String message, List data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
}
