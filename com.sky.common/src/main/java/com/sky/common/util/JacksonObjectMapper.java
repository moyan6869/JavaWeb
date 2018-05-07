package com.sky.common.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * 自定义 Jackson 序列化配置
 * 
 * @author linwh
 */

public class JacksonObjectMapper extends ObjectMapper {
	
	@SuppressWarnings("deprecation")
	public JacksonObjectMapper() {
		
		super();
		
		this.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS); //避免IE执行AJAX时,返回JSON出现下载文件
		
		//属性为null时输出空字符串
		this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>(){
			@Override
			public void serialize(Object obj, JsonGenerator jg,	SerializerProvider sp) throws IOException, JsonProcessingException {
				
				jg.writeString("");
			}
		});
		
	}
}
