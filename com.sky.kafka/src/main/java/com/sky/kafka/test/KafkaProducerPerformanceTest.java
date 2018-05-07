package com.sky.kafka.test;

import java.io.IOException;
import java.util.Properties;

import com.sky.common.util.JacksonUtil;
import com.sky.dao.model.MQOrderBean;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


/**
 * 生产
 * @author dao
 *
 */
public class KafkaProducerPerformanceTest{
	private static KafkaProducerPerformanceTest kafkaProducer = null;
	private final Producer<String, String> producer;
	public final static String TOPIC = "test03";
	public final static String location = "META-INF/spring/kafka-producer.properties";
	
	private KafkaProducerPerformanceTest() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(location));
		} catch (IOException e) {
		}
		producer = new Producer<String, String>(new ProducerConfig(props));
	}

	void produce(MQOrderBean mQOrderBean) {
		try{
			int messageNo = 1;
			String key = String.valueOf(messageNo);
			
			KeyedMessage<String, String> km = new KeyedMessage<String, String>(
					TOPIC, key, JacksonUtil.toJson(mQOrderBean));
			producer.send(km);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void destory() {
		if (producer != null) {
			producer.close();
		}
	}

	public static void main(String[] args) {
		int SEND_COUNT = Integer.parseInt(args[0]);
		try {
			kafkaProducer = new KafkaProducerPerformanceTest();
			for(int i=0;i<SEND_COUNT;i++){
				MQOrderBean mQOrderBean = new MQOrderBean();
				mQOrderBean.setMemberId("-1");
				mQOrderBean.setOrderId("关闭用消息，第" + i + "条");
				kafkaProducer.produce(mQOrderBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			kafkaProducer.destory();
		}
	}
	
}