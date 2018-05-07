package com.sky.kafka.impl;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.sky.common.util.DateUtil;
import com.sky.kafka.IKafkaProducer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 消息发送接口
 */
public class KafkaProducerImpl implements IKafkaProducer {
	
	private static final Logger logger = Logger.getLogger(KafkaProducerImpl.class);
	
	private Producer<String, String> producer = null;
	private Properties properties;
	private String topicName;//发送主题
     
	/**
	* @description:初始化消息发送
	* @author zenglinhua  2015-10-22
	 */
	public void init() {
		ProducerConfig config = new ProducerConfig(properties);
		producer = new Producer<String, String>(config);
	}
	
	/**
	* @description:发送消息到指定分区
	* @param vo 发送内容对象 必须序列化
    * @param msgKey 指定分区key
    * @return boolean
	* @author zenglinhua  2015-10-22
	 */
	@Override
	public boolean produceByKey(String string,String msgKey) {
		final String nowTm = DateUtil.getCurrDateStr(DateUtil.YEAR_TO_SEC_UN_LINE);
		KeyedMessage<String, String> km = new KeyedMessage<String, String>(topicName,msgKey,string);
		producer.send(km);
		logger.debug("kafka send TOPIC >>> "+topicName);
		return true;
	}
	
    /**
    * @description:发送消息到指定主题、指定分区
	* @param TOPIC指定主题
	* @param vo 发送内容对象 必须序列化
    * @param msgKey 指定分区key
    * @return boolean
    * @author zenglinhua  2015-10-22
     */
	@Override
	public boolean produce(String TOPIC,String string,String msgKey) {
		final String nowTm = DateUtil.getCurrDateStr(DateUtil.YEAR_TO_SEC_UN_LINE);
		
		KeyedMessage<String, String> km = new KeyedMessage<String, String>(TOPIC,msgKey,string);
		producer.send(km);
		logger.debug("kafka send TOPIC >>> "+TOPIC);
		return true;
	}
	
	/**
	* @description:发送消息到指定主题
	* @param TOPIC指定主题
	* @param vo 发送内容对象 必须序列化
	* @return boolean
	* @author zenglinhua  2015-10-22
	 */
	@Override
	public boolean produce(String TOPIC,String string) {
		final String nowTm = DateUtil.getCurrDateStr(DateUtil.YEAR_TO_SEC_UN_LINE);
		
		KeyedMessage<String, String> km = new KeyedMessage<String, String>(TOPIC,TOPIC,string);
		producer.send(km);
		logger.debug("kafka send TOPIC >>> "+TOPIC);
		return true;
	}

	/**
	* @description:发送消息到默认主题
	* @param vo 发送内容对象 必须序列化
	* @return boolean
	* @author zenglinhua  2015-10-22
	 */
	@Override
	public boolean produce(String string) {
		final String nowTm = DateUtil.getCurrDateStr(DateUtil.YEAR_TO_SEC_UN_LINE);
		
		KeyedMessage<String, String> km = new KeyedMessage<String, String>(topicName,topicName,string);
		producer.send(km);
		logger.debug("kafka send TOPIC >>> "+topicName);
		return true;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	* @description:销毁发送实例
	* @author zenglinhua  2015-10-22
	 */
	public void destory() {
		if (producer != null) {
			producer.close();
		}
	}
}