package com.sky.common.builder.bean;

/**
 * 生成器Bean类</br>
 * @version 1.0
 * @author  
 */
public class JavaCodeBean {
	/** 是否将数据库字段名字变成大写 */
	public boolean isColumnToUpperCase = false;
	/** 模板所在包名 */
	public String templatePackageName = "";
	/** 模板名字 */
	public String templateName = "";
	/** 模板类型后缀 */
	public String templateFileSuffix = "";
	/** 目标所在包名 */
	public String targetPackageName = "";
	/** 目标名字 */
	public String targetName = "";
	/** 目标名字前缀 */
	public String targetNamePrefix = "";
	/** 目标名字后缀 */
	public String targetNameSuffix = "";
	/** 目标文件类型后缀 */
	public String targetFileSuffix = "";
	/**
	 * 获取模板所在包名
	 * @return String 模板所在报名
	 * @version 1.0
	 * @data 2013-8-27 下午2:09:29
	 */
	public String getTemplatePackageName() {
		return templatePackageName;
	}
	/**
	 * 设置模板所在包名
	 * @param templatePackageName 模板所在包名
	 * @version 1.0
	 * @data 2013-8-27 下午2:09:47
	 */
	public void setTemplatePackageName(String templatePackageName) {
		this.templatePackageName = templatePackageName;
	}
	/**
	 * 获取模板名字
	 * @return String 模板名字
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:11:08
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置模板名字
	 * @param templateName 模板名字
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:11:21
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取模板类型后缀
	 * @return String 模板类型后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:11:33
	 */
	public String getTemplateFileSuffix() {
		return templateFileSuffix;
	}
	/**
	 * 设置模板类型后缀
	 * @param templateFileSuffix 模板类型后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:11:49
	 */
	public void setTemplateFileSuffix(String templateFileSuffix) {
		this.templateFileSuffix = templateFileSuffix;
	}
	/**
	 * 目标所在包名
	 * @return String 目标所在包名
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:12:16
	 */
	public String getTargetPackageName() {
		return targetPackageName;
	}
	/**
	 * 设置目标所在包名
	 * @param targetPackageName 目标所在包名
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:12:26
	 */
	public void setTargetPackageName(String targetPackageName) {
		this.targetPackageName = targetPackageName;
	}
	/**
	 * 获取目标文件类型后缀
	 * @return String 目标文件类型后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:12:44
	 */
	public String getTargetFileSuffix() {
		return targetFileSuffix;
	}
	/**
	 * 设置目标文件类型后缀
	 * @param targetFileSuffix 目标文件类型后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:12:55
	 */
	public void setTargetFileSuffix(String targetFileSuffix) {
		this.targetFileSuffix = targetFileSuffix;
	}
	/**
	 * 目标名字
	 * @return String 目标名字
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:13:16
	 */
	public String getTargetName() {
		return targetName;
	}
	/**
	 * 设置目标名字
	 * @param targetName 目标名字
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:13:22
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	/**
	 * 获取目标名字后缀
	 * @return String 目标名字后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:13:40
	 */
	public String getTargetNameSuffix() {
		return targetNameSuffix;
	}
	/**
	 * 设置目标名字后缀
	 * @param targetNameSuffix 目标名字后缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:13:50
	 */
	public void setTargetNameSuffix(String targetNameSuffix) {
		this.targetNameSuffix = targetNameSuffix;
	}
	/**
	 * 获取目标名字前缀
	 * @return String 目标名字前缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:14:06
	 */
	public String getTargetNamePrefix() {
		return targetNamePrefix;
	}
	/**
	 * 设置目标名字前缀
	 * @param targetNamePrefix 目标名字前缀
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:14:15
	 */
	public void setTargetNamePrefix(String targetNamePrefix) {
		this.targetNamePrefix = targetNamePrefix;
	}
	/**
	 * 获取数据库字段名是否大写的设置
	 * @return boolean
	 */
	public boolean isColumnToUpperCase() {
		return isColumnToUpperCase;
	}
	/**
	 * 设置数据库字段名是否大写
	 * @param isColumnToUpperCase true表示大写，false表示不设置大写
	 */
	public void setColumnToUpperCase(boolean isColumnToUpperCase) {
		this.isColumnToUpperCase = isColumnToUpperCase;
	}
	
}
