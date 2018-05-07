package com.sky.kafka.impl;

import java.util.List;
import java.util.Properties;

import com.sky.kafka.IKafkaConsumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.consumer.Whitelist;
import kafka.javaapi.consumer.ConsumerConnector;

/**
* @ClassName:KafkaConsumerImpl.java
* @Description:消息消费监听器实现
* @author:  zenglinhua 
* @date:    2015-10-22
 */
public class KafkaConsumerImpl implements IKafkaConsumer {
	
	private Properties properties;

    private ConsumerConnector consumer = null;
    
    private String topicName;
    
    /**
    * @description:初始化消息接收监听
    * @author zenglinhua  2015-10-22
     */
    public void init(){
        ConsumerConfig config = new ConsumerConfig(properties);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
    }
    
	/**
	* @description:接收指定主题消息列表
	* @param TOPIC 指定主题
	* @author zenglinhua  2015-10-22
	 */
    public List<KafkaStream<byte[], byte[]>> consumeList(String TOPIC) {
    	Whitelist whitelist = new Whitelist(TOPIC);
    	return consumer.createMessageStreamsByFilter(whitelist);
    }
    
	/**
	* @description:接收配置主题消息列表
	* @author zenglinhua  2015-10-22
	 */
    public List<KafkaStream<byte[], byte[]>> consumeList() {
    	Whitelist whitelist = new Whitelist(topicName);
    	return consumer.createMessageStreamsByFilter(whitelist);
    }
    
	/**
	* @description:提交消费确认
	* @author zenglinhua  2015-10-22
	 */
    public void commitOffsets(){
    	consumer.commitOffsets();
    }
    
    /**
    * @description:销毁接收实例
    * @author zenglinhua  2015-10-22
     */
    public void destory(){
    	if(consumer!=null){
    		consumer.shutdown();
    	}
    }

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
}