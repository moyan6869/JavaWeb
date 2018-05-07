package com.sky.kafka;

public interface IKafkaProducer {
	
    /**
    * @description:发送消息到指定主题、指定分区
	* @param TOPIC指定主题
	* @param vo 发送内容对象 必须序列化
    * @param msgKey 指定分区key
    * @return boolean
    * @author zenglinhua  2015-10-22
     */
	boolean produce(String TOPIC,String string,String msgKey);
	/**
	* @description:发送消息到指定主题
	* @param TOPIC指定主题
	* @param vo 发送内容对象 必须序列化
	* @return boolean
	* @author zenglinhua  2015-10-22
	 */
	boolean produce(String TOPIC,String string);
	
	/**
	* @description:发送消息到指定分区
	* @param vo 发送内容对象 必须序列化
    * @param msgKey 指定分区key
    * @return boolean
	* @author zenglinhua  2015-10-22
	 */
	boolean produceByKey(String string,String msgKey);
	/**
	* @description:发送消息到默认主题
	* @param vo 发送内容对象 必须序列化
	* @return boolean
	* @author zenglinhua  2015-10-22
	 */
	boolean produce(String string);
	
	/**
	* @description:销毁发送实例
	* @author zenglinhua  2015-10-22
	 */
	void destory();

}
