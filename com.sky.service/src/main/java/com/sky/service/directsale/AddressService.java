package com.sky.service.directsale;

import java.util.List;

import com.sky.dao.vo.AddressBean;

/**
 * AddressService
 * @author Geoffrey
**/
public interface AddressService {
	
	
	/**
	 * 查询所有数据
	 * @return List<SysMenuExtendBean>
	 * @throws Exception
	 */
	public List<AddressBean> listAll() throws Exception;
	
}
