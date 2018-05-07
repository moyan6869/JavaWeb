package com.sky.common;

import java.io.Serializable;

public class HttpBase implements Serializable{
	public boolean success;//是否成功
	
	public String status;//响应码
	
	public String msg;//消息
	
	public Object data;//响应数据
}
