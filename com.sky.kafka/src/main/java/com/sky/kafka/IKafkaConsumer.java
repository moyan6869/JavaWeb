package com.sky.kafka;

import java.util.List;

import kafka.consumer.KafkaStream;

/**
* @ClassName:IKafkaConsumer.java
* @Description:消息消费监听器接口
* @author:  zenglinhua
* @date:    2015-10-22
 */
public interface IKafkaConsumer {
	/**
	* @description:接收指定主题消息列表
	* @param TOPIC 指定主题
	* @author zenglinhua  2015-10-22
	 */
	List<KafkaStream<byte[], byte[]>> consumeList(String TOPIC);
	
	/**
	* @description:接收配置主题消息列表
	* @author zenglinhua  2015-10-22
	 */
    public List<KafkaStream<byte[], byte[]>> consumeList();
	
	/**
	* @description:提交消费确认
	* @author zenglinhua  2015-10-22
	 */
	void commitOffsets();
    
    /**
    * @description:销毁接收实例
    * @author zenglinhua  2015-10-22
     */
    void destory();

}