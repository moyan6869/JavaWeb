package com.sky.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class BuidSpringUtil {
	private static final String configPaths = "classpath:resources/spring/applicationContext_*.xml";
	/** web的spring容器 */
	public static WebApplicationContext webAppContent;
	/** java的spring容器 */
	public static ApplicationContext appContent;

	/**
	 * 此方法直接获取resin、tomcat启动后的容器。
	 * @param beanId beanID
	 * @return Object bean类
	 * @version 1.0
	 * @author    
	 * @data 2013-8-9 上午9:35:28
	 */
	public static Object getBeanById(String beanId) {
		if (null==webAppContent) webAppContent = ContextLoader.getCurrentWebApplicationContext();
		if (null!=webAppContent) return webAppContent.getBean(beanId);
		else {
			if (appContent == null) appContent = new ClassPathXmlApplicationContext(new String[]{configPaths});
			return appContent.getBean(beanId);
		}
	}
}
