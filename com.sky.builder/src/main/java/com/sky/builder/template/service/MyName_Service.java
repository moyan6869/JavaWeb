package com.sky.builder.template.service;

import java.util.List;
import java.util.Map;

import com.sky.builder.template.bean.MyName_Bean;
import com.sky.common.bean.StatusBean;

/**
 * MyName_Service
 * @author 作者_
**/
public interface MyName_Service {
	/**
	 * 根据ID获取类别信息
	 * @param id 数据ID
	 * @return MyName_Bean 数据bean对象
	 * @throws Exception
	 **/
	public MyName_Bean getBeanById(String id,String module) throws Exception;
	
	/**
	 * 根据给定的条件获取对象
	 * @param  params 参数
	 * @return MyName_Bean 数据bean对象
	 * @throws Exception
	 **/
	public MyName_Bean get(Map<String, Object> params,String module) throws Exception;
	
	/**
	 * 查询所有数据
	 * @return List<SysMenuExtendBean>
	 * @throws Exception
	 */
	public List<MyName_Bean> listAll(String module) throws Exception;
	/**
	 * 查询记录总数
	 * @param params 查询条件
	 * @return int 查询的记录总数
	 * @throws Exception
	 **/
	public int count(MyName_Bean brean,String module) throws Exception;
	/**
	 * 查询所有数据
	 * @param params 查询条件
	 * @return List<MyName_Bean> 查询后返回的结果集
	 * @throws Exception
	 **/
	public List<MyName_Bean> list(Map<String, Object> params,String module) throws Exception;
	/**
	 * 保存
	 * @param bean 需要保存的bean对象
	 * @param user 当前操作人
	 * @return StatusBean 操作状态
	 * @throws Exception
	 **/
	public StatusBean<?> save(MyName_Bean bean,String module) throws Exception;
	/**
	 * 更新
	 * @param bean 需要更新的bean对象
	 * @param user 当前操作人
	 * @return boolean 返回true表示更新成功；返回false表示更新失败； 
	 * @throws Exception
	 **/
	public StatusBean<?> update(MyName_Bean bean,String module) throws Exception;
	/**
	 * 删除
	 * @param id 待删除的数据ID
	 * @return boolean 返回true表示删除成功；返回false表示删除失败；
	 * @throws Exception
	 **/
	public StatusBean<?> deleteById(String id,String module)  throws Exception;
}