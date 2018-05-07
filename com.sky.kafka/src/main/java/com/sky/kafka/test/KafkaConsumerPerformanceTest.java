package com.sky.kafka.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.consumer.Whitelist;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;


/**
 * 消费
 * @author dao
 *
 */
public class KafkaConsumerPerformanceTest implements Runnable {
	
	private static KafkaConsumerPerformanceTest kafkaConsumer;
    private String topicName = "";
    Properties props = null;
    public final static String location = "META-INF/test_conf/test_kafka-consumer.properties";
    private static int SEND_COUNT = 0;
	private static long useTime = 0;
	private static long totalTime = 0;
	private static long maxTime = 0;
	private static long minTime = 0;
	private static int executeThreadCount = 0;

    private KafkaConsumerPerformanceTest() {
        props = new Properties();
    	try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    void consume() {
    	ConsumerConfig config = new ConsumerConfig(props);
    	ConsumerConnector consumer = Consumer.createJavaConsumerConnector(config);
    	try{
    		Date staDt = new Date();
    		int count = 0;
            List<KafkaStream<byte[], byte[]>> partitions = consumer.createMessageStreamsByFilter(new Whitelist(topicName));
            for (KafkaStream<byte[], byte[]> partition : partitions) {
    			ConsumerIterator<byte[], byte[]> it = partition.iterator();
    	        while (it.hasNext()){
    	            StringBuffer sb = new StringBuffer();
    	            MessageAndMetadata<byte[], byte[]> metaData = it.next();
    	     	    byte[] bytes = metaData.message();
    	     	   // MessageBean mb = (MessageBean) BeanUtils.bytes2Object(bytes);
    	     	    sb.append("Part: " + metaData.partition() + " ");
    	     	    sb.append("Key: " + metaData.key() + " ");
    	     	    //sb.append("tm: " + mb.getDatetimes()+ " ");
    	     	   // sb.append("Message: " + mb.getContent());
    	     	    System.err.println(sb.toString());
    	     	    consumer.commitOffsets();
    	     	    if(++count==SEND_COUNT){
    	    			Date endDt = new Date();
    	    			useTime = endDt.getTime() - staDt.getTime();
    	    			totalTime += useTime;
    	    			if(maxTime==0 || useTime>maxTime){
    	    				maxTime = useTime;
    	    			}
    	    			if(minTime==0 || useTime<minTime){
    	    				minTime = useTime;
    	    			}
    	    			consumer.shutdown();
    	    			break;
    	     	    }
    	        }
    		}
    	}catch(Exception e){
			e.printStackTrace();
		}finally{
			executeThreadCount ++;
		}
    	
    }
    
    public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public static void main(String[] args) {
		kafkaConsumer = new KafkaConsumerPerformanceTest();
		int threadCount = Integer.parseInt(args[0]); 
		SEND_COUNT = Integer.parseInt(args[1]);
		ExecutorService fixedThreadPool = Executors
				.newFixedThreadPool(threadCount);
		
		for(int i =0;i< threadCount;i++){
			fixedThreadPool.execute(kafkaConsumer);
		}
		try {
			while(true){
				if(executeThreadCount == threadCount){
					break;
				}
				Thread.sleep(1000);
			}  
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			fixedThreadPool.shutdown();
		}
		System.out.println("threadCount:" + threadCount);
		System.out.println("SEND_COUNT:" + SEND_COUNT);
		System.out.println("avg_time:"+(totalTime/threadCount));
		System.out.println("maxTime:"+maxTime);
		System.out.println("minTime:"+minTime);
		System.out.println("everySecond:"+(SEND_COUNT*threadCount*1000)/(totalTime/threadCount));
    }

	@Override
	public void run() {
		kafkaConsumer.consume();
	}
}