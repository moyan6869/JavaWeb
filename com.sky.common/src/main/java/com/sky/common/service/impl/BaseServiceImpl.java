package com.sky.common.service.impl;

import com.sky.common.bean.StatusBean;
import org.apache.log4j.Logger;

/**
 * @Description: 服务层基类
 * @author    
 * @date 2014年3月4日 下午1:53:07
 */
public class BaseServiceImpl {
	/** 日志类 */
	public Logger log = Logger.getLogger(this.getClass());
	/** 开始行数 */
	protected String startRow = "startRow";
	/** 显示多少条 */
	protected String rows = "rows";
	/**
	 * @Description: 操作成功，有提示信息，无结果对象
	 * @author    
	 * @date 2014年3月4日 下午2:00:06
	 * @param msg 提示信息
	 * @return StatusBean
	 */
	public StatusBean success(String msg){
		return new StatusBean(true,"0000",msg,null);
	}
	/**
	 * @Description: 操作成功，有提示信息，有结果对象
	 * @author    
	 * @date 2014年3月4日 下午1:59:40
	 * @param msg 提示信息
	 * @param result 结果对象
	 * @return StatusBean
	 */
	public StatusBean success(String msg, Object result){
		return new StatusBean(true,"0000",msg,result);
	}
	/**
	 * @Description: 操作成功，有提示信息，有结果对象
	 * @author    
	 * @date 2014年3月4日 下午1:59:40
	 * @param msg 提示信息
	 * @param result 结果对象
	 * @return StatusBean
	 */
	public StatusBean success(String code, String msg, Object result){
		return new StatusBean(true,code,msg,result);
	}
	/**
	 * 操作成功，无提示信息，有结果对象
	 * @param result 结果对象
	 * @return StatusBean
	 */
	public StatusBean success(Object result){
		return new StatusBean(true,"0000",null,result);
	}
	/**
	 * 操作失败
	 * @param msg 提示消息
	 * @return StatusBean
	 */
	public StatusBean error(String msg){
		return new StatusBean(false,"9999",msg,null);
	}
	/**
	 * 操作失败
	 * @author    
	 * @date 2014年6月20日 下午4:44:31 
	 * @version V1.0   
	 * @param msg
	 * @param result
	 * @return StatusBean
	 */
	public StatusBean error(String msg, Object result){
		return new StatusBean(false,"9999",msg,result);
	}
	/**
	 * 操作失败
	 * @author    
	 * @date 2014年6月20日 下午4:45:45 
	 * @version V1.0   
	 * @param errCode
	 * @param msg
	 * @param result
	 * @return StatusBean
	 */
	public StatusBean error(String errCode, String msg, Object result){
		return new StatusBean(false,errCode,msg,result);
	}
	
	/**
	 * 数据重复
	* @Title: repeat 
	* @Description: TODO
	* @param msg
	* @return
	* @return StatusBean    
	* @author dao
	* @date 2014年3月25日 下午1:52:59
	 */
	public StatusBean repeat( String msg ){
		return new StatusBean(false,msg,1);
	}
}
