/** 
 * @Title:对象拷贝工具
 * @Desription:List对象拷贝工具
 * @Company:sibu
 * @ClassName:ObjectCopyUtil.java
 * @Author:ZCP
 * @CreateDate:2015-3-30     
 * @Version:0.1 
 *    
 */

package com.sky.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @ClassName: ObjectCopyUtil
 * @Description: 对象拷贝工具
 * @author: ZCP
 * @date: 2015-3-30
 * 
 */
public final class ObjectCopyUtil {
	
	private ObjectCopyUtil() {
		super();
	}
	private static Logger LOGGER = Logger.getLogger(ObjectCopyUtil.class);
	/**
	 * @Desription:深层拷贝List集合对象
	 * @param srcList
	 *            源List集合
	 * @return 深层拷贝的List集合
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @Return:List<T>
	 * @Author:ZCP
	 * @CreateDate:2015-3-30
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> deepCopyList(List<T> srcList) {
		List<T> dest=null;
		try {
			ByteArrayOutputStream byteout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteout);
			out.writeObject(srcList);
			ByteArrayInputStream bytein = new ByteArrayInputStream(
					byteout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bytein);
			dest = (List<T>) in.readObject();
		} catch (ClassNotFoundException e) {
			LOGGER.error("深层拷贝List集合对象出错!",e);
		} catch (IOException e) {
			LOGGER.error("深层拷贝List集合对象出错!",e);
		}
		return dest;
	}
	/**
	 * @Desription:深层拷贝Map对象
	 * @param srcMap 源Map对象
	 * @return 深层拷贝的Map对象
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @Return:Map
	 * @Author:ZCP
	 * @CreateDate:2015-3-30
	 */
	@SuppressWarnings("rawtypes")
	public static Map deepCopyMap(Map srcMap){
		ByteArrayOutputStream byteout = new ByteArrayOutputStream();
		Map dest=null;
		try {
			ObjectOutputStream out = new ObjectOutputStream(byteout);
			out.writeObject(srcMap);
			ByteArrayInputStream bytein = new ByteArrayInputStream(
					byteout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bytein);
			dest = (Map) in.readObject();
		} catch (ClassNotFoundException e) {
			LOGGER.error("深层拷贝Map对象出错!",e);
		} catch (IOException e) {
			LOGGER.error("深层拷贝Map对象出错!",e);
		}
		return dest;
	}
}
