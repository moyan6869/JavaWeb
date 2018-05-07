package com.sky.common.util;

import com.sky.common.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProfitUtil {
	
	private static ApplicationContext context;
	
	static{
		context = new  ClassPathXmlApplicationContext(Constants.LOCATION);
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	
	
}
