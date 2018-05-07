package com.sky.builder.template.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sky.builder.template.service.MyName_Service;
import org.springframework.stereotype.Service;

import com.sky.builder.template.bean.MyName_Bean;
import com.sky.common.bean.StatusBean;
import com.sky.common.service.impl.BaseServiceImpl;

/**
 * MyName_ServiceImpl
 * @author 作者_
 **/
@Service("myName_Service")
public class MyName_ServiceImpl extends BaseServiceImpl implements MyName_Service {
	
	
	@Override
	public MyName_Bean getBeanById(String id,String module) throws Exception{
		MyName_Bean bean = new MyName_Bean();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql="";
//		bean = JdbcModuleDaoSupport.getObjectDateInfo(sql, params, bean,module);
		return bean;
	}
	@Override
	public List<MyName_Bean> listAll(String module) throws Exception {
		MyName_Bean bean = new MyName_Bean();
		String sql = " ";
//		return JdbcModuleDaoSupport.getList(sql, bean,module);
        return null;
	}
	@Override
	public int count(MyName_Bean brean,String module) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "";
//		return JdbcModuleDaoSupport.count(sql, params,module);
        return 0;
	}
	@Override
	public List<MyName_Bean> list(Map<String, Object> params,String module) throws Exception {
		MyName_Bean bean = new MyName_Bean();
		String sql = "";
//		return JdbcModuleDaoSupport.getList(sql, bean,module);
        return null;
	}
	 
	@Override
	public StatusBean<?> save(MyName_Bean bean,String module) throws Exception {
		Date currDate = new Date();
		String sql="";
		//TODO 处理业务
//		bean.setId(StringUtil.getUUID());
//		if(JdbcModuleDaoSupport.updateOrAddOrDele(sql, bean,module)){
//        	return success("操作成功！");
//        }
		return error("增加失败"); 
	}
	@Override
	public StatusBean<?> update(MyName_Bean bean,String module) throws Exception {
		Date currDate = new Date();
		String sql="";
//		if(JdbcModuleDaoSupport.updateOrAddOrDele(sql, bean,module)){
//			return success("操作成功！");
//		}else{
//			return error("修改失败");
//		}
        return null;
	}
	@Override
	public StatusBean<?> deleteById(String id,String module) throws Exception {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		String sql ="";
//		if(JdbcModuleDaoSupport.updateOrAddOrDele(sql, params,module)){
//			return success("操作成功！");
//		}else{
//			return error("修改失败");
//		}
        return null;
	}
	@Override
	public MyName_Bean get(Map<String, Object> params,String module) throws Exception {
		MyName_Bean bean = new MyName_Bean();
		String sql = "";
//		bean = JdbcModuleDaoSupport.getObjectDateInfo(sql, params, bean,module);
		return bean;
	}
	
}