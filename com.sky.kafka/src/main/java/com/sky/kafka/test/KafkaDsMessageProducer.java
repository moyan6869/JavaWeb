package com.sky.kafka.test;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import com.sky.kafka.impl.KafkaProducerImpl;
import com.sky.common.util.JacksonUtil;
import com.sky.dao.enums.JPushType;
import com.sky.dao.model.DSMessageBean;
import com.sky.kafka.util.Util;
/**
 * 生产
 * @author dao
 *
 */
public class KafkaDsMessageProducer{
	private static KafkaProducerImpl kafkaProducer;
	private static String TOPIC = "DS_Message_Topic";
	private final static String location = "META-INF/spring/test_kafka-producer.properties";
	
	private KafkaDsMessageProducer() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(location));
			kafkaProducer = new KafkaProducerImpl();
			kafkaProducer.setProperties(props);
			kafkaProducer.init();
		} catch (IOException e) {
		}
	}

	void produce(DSMessageBean dsMessageBean) {
		try{
			Random r = new Random();
			
				
				 boolean bl = kafkaProducer.produce(TOPIC,JacksonUtil.toJson(dsMessageBean),r.nextInt(16)+"");
			System.out.println(bl+dsMessageBean.toString());
		}catch(Exception e){
			System.out.println("发送消息失败!");
		}finally{
			//
		}
		
	}
	
	void levelMember()
	{
		for(int i = 0;i < 5; i++)
		{
			DSMessageBean dsMessageBean = new DSMessageBean();
			dsMessageBean.setType(1);
			dsMessageBean.setContent("lailo"+i);
			dsMessageBean.setjPushType(JPushType.Achivement.getCode());
			dsMessageBean.setMemberId("23eee640972a481985781d2526ac2a96");
			produce(dsMessageBean);
		}
	}
	
	public static void main(String[] args) {
		int level = 0;
		
		Util.getApplicationContext();
		
		new KafkaDsMessageProducer().levelMember();
		
		kafkaProducer.destory();
	}
	
}