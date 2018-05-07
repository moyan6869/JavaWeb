package com.sky.service.directsale.impl;

import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.dao.vo.AddressBean;
import com.sky.service.directsale.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AddressServiceImpl
 * @author Geoffrey
 **/
@Service("addressService")
public class AddressServiceImpl extends BaseServiceImpl implements AddressService {
	@Override
	public List<AddressBean> listAll() throws Exception {
		AddressBean bean = new AddressBean();
		String sql = " SELECT * FROM address ";
		return JdbcTemplateDaoSupport.getList(sql, bean);
	}	
}
