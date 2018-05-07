package com.sky.service.directsale.impl;

import com.sky.common.bean.StatusBean;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.dao.vo.ServerConfigBean;
import com.sky.service.directsale.ServerConfigService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ServerConfigServiceImpl
 * @author dao
 **/
@Service("serverConfigService")
public class ServerConfigServiceImpl extends BaseServiceImpl implements ServerConfigService {
	
	
	@Override
	public ServerConfigBean getBeanById(String id) throws Exception{
		ServerConfigBean bean = new ServerConfigBean();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("modules", id);
		String sql="";
		bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, params, bean);
		return bean;
	}
	@Override
	public List<ServerConfigBean> listAll() throws Exception {
		ServerConfigBean bean = new ServerConfigBean();
		String sql = " ";
		return JdbcTemplateDaoSupport.getList(sql, bean);
	}
	@Override
	public int count(ServerConfigBean brean) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "";
		return JdbcTemplateDaoSupport.count(sql, params);
	}
	@Override
	public List<ServerConfigBean> list(Map<String, Object> params) throws Exception {
		ServerConfigBean bean = new ServerConfigBean();
		String sql = "";
		return JdbcTemplateDaoSupport.getList(sql, bean);
	}
	 
	@Override
	public StatusBean<?> save(ServerConfigBean bean) throws Exception {
		Date currDate = new Date();
		String sql="";
		//TODO 处理业务
//		bean.setId(StringUtil.getUUID());
		if(JdbcTemplateDaoSupport.updateOrAddOrDele(sql, bean)){
        	return success("操作成功！");
        }
		return error("增加失败"); 
	}
	@Override
	public StatusBean<?> update(ServerConfigBean bean) throws Exception {
		Date currDate = new Date();
		String sql="";
		if(JdbcTemplateDaoSupport.updateOrAddOrDele(sql, bean)){
			return success("操作成功！");
		}else{
			return error("修改失败");
		}
	}
	@Override
	public StatusBean<?> deleteById(String id) throws Exception {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql ="";
		if(JdbcTemplateDaoSupport.updateOrAddOrDele(sql, params)){
			return success("操作成功！");
		}else{
			return error("修改失败");
		}
	}
	@Override
	public ServerConfigBean get(Map<String, Object> params) throws Exception {
		ServerConfigBean bean = new ServerConfigBean();
		String sql = "";
		bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, params, bean);
		return bean;
	}
	
}
