package com.sky.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogUtil {
	
	private static ApplicationContext context;
	
	static{
		context = new  ClassPathXmlApplicationContext(Constants.LOCATION);
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	
	
}
