/** 
 * @Title:List对象排序的通用工具
 * @Desription:List对象排序的通用工具
 * @ClassName:ListSort.java
 * @Author: ZCP
 * @CreateDate:2015年8月24日     
 * @Version:0.1 
 *    
 */

package com.sky.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sky.common.Constants;
import org.apache.log4j.Logger;

/**
 * @ClassName: ListSort
 * @Description: List对象排序的通用工具
 * @author: ZCP
 * @date: 2015年8月24日
 * 
 */
public class ListSort<E> {
	private static Logger LOGGER = Logger.getLogger(ListSort.class);

	/**
	 * @param list
	 *            要排序的集合
	 * @param method
	 *            要排序的实体的属性所对应的get方法
	 * @param sort
	 *            desc 为降序 asc升序
	 */
	public void Sort(List<E> list, final String method, final String sort) {
		// 用内部类实现排序
		Collections.sort(list, new Comparator<E>() {
			public int compare(E a, E b) {
				int ret = 0;
				try {
					// 获取m1的方法名
					Method m1 = a.getClass().getMethod(method, null);
					// 获取m2的方法名
					Method m2 = b.getClass().getMethod(method, null);

					if (sort != null && Constants.SORT_DESC.equals(sort)) {
						ret = m2.invoke(((E) b), null).toString()
								.compareTo(m1.invoke(((E) a), null).toString());
					} else {
						// 升序排序
						ret = m1.invoke(((E) a), null).toString()
								.compareTo(m2.invoke(((E) b), null).toString());
					}
				} catch (NoSuchMethodException ne) {
					LOGGER.error("List集合排序出错!", ne);
				} catch (IllegalArgumentException e) {
					LOGGER.error("List集合排序出错!", e);
				} catch (IllegalAccessException e) {
					LOGGER.error("List集合排序出错!", e);
				} catch (InvocationTargetException e) {
					LOGGER.error("List集合排序出错!", e);
				}
				return ret;
			}
		});
	}
}
