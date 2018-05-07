package com.sky.kafka.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Util {
	
	private static ApplicationContext context;
	
	static{
		context = new  ClassPathXmlApplicationContext(Constants.LOCATION);
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	
	
}
