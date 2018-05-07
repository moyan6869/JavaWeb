/**   
* @Title: OrderCount.java 
* @Package com.sibu.directSale.web.model 
* @Description: 订单统计信息
* @author zenglinhua
* @date 2015年11月11日 下午3:27:55 
* @version V1.0   
*/ 
package com.sky.web.model;

import java.io.Serializable;
import java.util.List;

import com.sky.dao.vo.DoingOrderBean;

/** 
 * @ClassName: OrderCount 
 * @Description: 订单统计信息
 * @author zenglinhua
 * @date 2015年11月11日 下午3:27:55 
 *  
 */
public class OrderCount implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = 1893961927195434699L;

	/**
	 * 分库模
	 */
	private String module;
	
	/**
	 * 显示名称
	 */
	private String label;
	
	/**
	 * 统计数
	 */
	private int count;
	
	/**
	 * 符合条件的数据
	 */
	private List<DoingOrderBean> datas;

	/** 
	 * @return module 
	 */
	public String getModule() {
		return module;
	}

	/** 
	 * @param module 要设置的 module 
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/** 
	 * @return label 
	 */
	public String getLabel() {
		return label;
	}

	/** 
	 * @param label 要设置的 label 
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/** 
	 * @return count 
	 */
	public int getCount() {
		return count;
	}

	/** 
	 * @param count 要设置的 count 
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public List<DoingOrderBean> getDatas() {
		return datas;
	}

	public void setDatas(List<DoingOrderBean> datas) {
		this.datas = datas;
	}
	
	
}
