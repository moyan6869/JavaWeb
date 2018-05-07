package com.sky.common.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sky.dao.log.TradeLogBean;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;

import com.sky.common.massage.ResponseUtil;
import com.sky.dao.vo.MemberBean;

/**
 * json转换集合类型
 * 
 * @author linwh
 */

public class JacksonUtil {
	
	private static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	//private static final ObjectMapper mapper = new ObjectMapper();
	private static final ObjectMapper mapper = new JacksonObjectMapper();

	private static ObjectMapper getInstance() {

		return mapper;
	}


	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	private static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}

	/**
	 * 转换集合类型
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> convertList(String jsonString, Class<T> clazz) {
		if (jsonString != null && !"".equals(jsonString)) {
			JavaType javaType = getCollectionType(ArrayList.class, clazz);
			List<T> list = null;
			try {
				list =  mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return list;
		}

		return null;
	}
	
	/**
	 * 转换map类型
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> convertMap(String jsonString){
		
		if (jsonString != null && !"".equals(jsonString)) {
			JavaType javaType = getCollectionType(HashMap.class, String.class, Object.class);
			try {
				return mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	
	/**
	 * 对象序列化
	 * 
	 * @param obj 需要序列化的对象
	 * @return 返回json字符串
	 */
	public static String toJson(Object obj){
		try {
			mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
//			if (obj instanceof Response)  {
//				if(StringUtil.isNull(((Response) obj).getData())) {
//					mapper.setSerializationInclusion(Inclusion.NON_NULL);  //只要是空的都不传
//				}
//				else {
//					mapper.setSerializationInclusion(Inclusion.ALWAYS);  //只要是空的都不传
//				}
//			}

			mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
			
			return mapper.writeValueAsString(obj); 
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 将JSON转换成object
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz){
		
		try {
			mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
			T t = mapper.readValue(json, clazz);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
//		String jsonString = "{\"creator.id\":\"\",\"status\":\"\",\"realname\":\"林文豪\",\"username\":\"lwh\",\"mobile\":\"\"}";
//		;
//		Map<String, Object>  result = JacksonUtil.convertMap(js onString);
//		MemberBean mb = new MemberBean();
//		mb.setDeleteFlag(1);
//		String s= ResponseUtil.data(mb);

		TradeLogBean logBean=new TradeLogBean();

		System.out.println("rere"+JacksonUtil.toJson(logBean));
	}
}
