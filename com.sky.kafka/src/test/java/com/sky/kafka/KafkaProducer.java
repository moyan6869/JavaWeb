package com.sky.kafka;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.sky.common.util.JacksonUtil;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Hello world!
 *
 */
public class KafkaProducer implements Runnable {
	public static Logger log = Logger.getLogger(KafkaProducer.class);
	private static KafkaProducer kafkaProducer = null; 
	private final Producer<String, String> producer;
	public final static String TOPIC = "test_3";
	private String topicName = TOPIC;
	public final static String location = "META-INF/test_conf/test_kafka-producer.properties";
	private static int SEND_COUNT = 0;
	private static long useTime = 0;
	private static long totalTime = 0;
	private static long maxTime = 0;
	private static long minTime = 0;
	private static int executeThreadCount = 0;
	
	private KafkaProducer() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(location));
		} catch (IOException e) {
		}
		producer = new Producer<String, String>(new ProducerConfig(props));
	}

	/**
	 * 
	* @Title: produce 
	* @Description: 按指定循环次数发送消息
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	void produce() {
		try{
			int messageNo = 1;
			//开始时间时间点
			Date staDt = new Date();
			while (messageNo < SEND_COUNT) {
				//String key = String.valueOf(messageNo);
				String data = "12345678";
				
				KeyedMessage<String, String> km = new KeyedMessage<String, String>(
						topicName, JacksonUtil.toJson(data));
				log.debug("kafka send TOPIC >>> "+km);
				producer.send(km);
				messageNo++;
			}
			//结束时间时间点
			Date endDt = new Date();
			useTime = endDt.getTime() - staDt.getTime();
			totalTime += useTime;
			if(maxTime==0 || useTime>maxTime){
				maxTime = useTime;
			}
			if(minTime==0 || useTime<minTime){
				minTime = useTime;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			executeThreadCount ++;
		}
		
	}

	/**
	 * 
	* @Title: setTopicName 
	* @Description: 设置消息主题名称
	* @param @param topicName    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * 
	* @Title: destory 
	* @Description: 关闭生产者连接
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void destory() {
		if (producer != null) {
			producer.close();
		}
	}

	/**
	 * 
	* @Title: main 
	* @Description: 主函数入口（需要两个参数：第一个线程数,第二个循环发送次数）
	* @param @param args    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void main(String[] args) {
		int threadCount = 1/*Integer.parseInt(args[0])*/;
		SEND_COUNT = 2/*Integer.parseInt(args[1])*/;
		kafkaProducer = new KafkaProducer();
		ExecutorService fixedThreadPool = Executors
				.newFixedThreadPool(threadCount);
		
		for(int i =0;i< threadCount;i++){
			fixedThreadPool.execute(kafkaProducer);
		}
		try {
			while(true){//等待所有子线程执行完  
				if(executeThreadCount == threadCount){
					break;
				}
				Thread.sleep(1000);
			}  
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			fixedThreadPool.shutdown();
			kafkaProducer.destory();
		}
		
		System.out.println("threadCount:" + threadCount);
		System.out.println("sendCount:" + SEND_COUNT);
		System.out.println("avgTime:"+(totalTime/threadCount));
		System.out.println("maxTime:"+maxTime);
		System.out.println("minTime:"+minTime);
		System.out.println("everysec "+SEND_COUNT*threadCount*1000/(totalTime/(threadCount)));
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: run
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		kafkaProducer.produce();
	}
}