package com.sky.service.directsale;

import java.util.List;
import java.util.Map;

import com.sky.common.bean.StatusBean;
import com.sky.dao.vo.ServerConfigBean;

/**
 * ServerConfigService
 * @author dao
**/
public interface ServerConfigService {
	/**
	 * 根据ID获取类别信息
	 * @param id 数据ID
	 * @return ServerConfigBean 数据bean对象
	 * @throws Exception
	 **/
	public ServerConfigBean getBeanById(String id) throws Exception;
	
	/**
	 * 根据给定的条件获取对象
	 * @param  params 参数
	 * @return ServerConfigBean 数据bean对象
	 * @throws Exception
	 **/
	public ServerConfigBean get(Map<String, Object> params) throws Exception;
	
	/**
	 * 查询所有数据
	 * @return List<SysMenuExtendBean>
	 * @throws Exception
	 */
	public List<ServerConfigBean> listAll() throws Exception;
	/**
	 * 查询记录总数
	 * @param params 查询条件
	 * @return int 查询的记录总数
	 * @throws Exception
	 **/
	public int count(ServerConfigBean brean) throws Exception;
	/**
	 * 查询所有数据
	 * @param params 查询条件
	 * @return List<ServerConfigBean> 查询后返回的结果集
	 * @throws Exception
	 **/
	public List<ServerConfigBean> list(Map<String, Object> params) throws Exception;
	/**
	 * 保存
	 * @param bean 需要保存的bean对象
	 * @param user 当前操作人
	 * @return StatusBean 操作状态
	 * @throws Exception
	 **/
	public StatusBean<?> save(ServerConfigBean bean) throws Exception;
	/**
	 * 更新
	 * @param bean 需要更新的bean对象
	 * @param user 当前操作人
	 * @return boolean 返回true表示更新成功；返回false表示更新失败； 
	 * @throws Exception
	 **/
	public StatusBean<?> update(ServerConfigBean bean) throws Exception;
	/**
	 * 删除
	 * @param id 待删除的数据ID
	 * @return boolean 返回true表示删除成功；返回false表示删除失败；
	 * @throws Exception
	 **/
	public StatusBean<?> deleteById(String id)  throws Exception;
}
