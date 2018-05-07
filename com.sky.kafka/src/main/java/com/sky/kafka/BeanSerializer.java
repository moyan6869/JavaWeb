package com.sky.kafka;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;



/**
* @ClassName:BeanSerializer.java
* @Description:消息序列化
* @author:  zenglinhua
* @date:    2015-10-22
 */
public class BeanSerializer implements Encoder<String> {
	public BeanSerializer(VerifiableProperties props) {
	}

	@Override
	public byte[] toBytes(String mb) {
		return mb.getBytes();
		//return BeanUtils.object2Bytes(mb);
	}
}
