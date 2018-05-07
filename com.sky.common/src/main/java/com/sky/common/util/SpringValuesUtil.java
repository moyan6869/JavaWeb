package com.sky.common.util;

import java.util.Properties;


/**
 * 公共 配置 获取的值 对应着 vlaue.properties
 * @author dao
 *
 */
public class SpringValuesUtil {
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		String value = "";
		Properties proper = SpringUtils.getBean("valuesProperties");
		value = proper.getProperty(key);
		return value;
	}
}
