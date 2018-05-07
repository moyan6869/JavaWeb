package com.sky.kafka;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

public class KafkaConsumer {

    private final ConsumerConnector consumer;
    
    private String topicName = KafkaProducer.TOPIC;
    
    private Integer partitionNum = 1;
    
    public final static String location = "META-INF/test_conf/test_kafka-consumer.properties";

    private KafkaConsumer() {
        Properties props = new Properties();
    	try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(location));
		} catch (IOException e) {
		}
        ConsumerConfig config = new ConsumerConfig(props);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
    }

    void consume() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topicName,partitionNum);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topicName).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()){
            StringBuffer sb = new StringBuffer();
            MessageAndMetadata<byte[], byte[]> metaData = it.next();
     	    byte[] bytes = metaData.message();
     	    MessageBean mb = (MessageBean) BeanUtils.bytes2Object(bytes);
     	    sb.append("Part: " + metaData.partition() + " ");
     	    sb.append("Key: " + metaData.key() + " ");
     	    sb.append("tm: " + mb.getDatetimes()+ " ");
     	    sb.append("Message: " + mb.getContent().toString()+ " ");
     	    System.err.println(sb.toString());
            consumer.commitOffsets();
        }
    }
    
    public void destory(){
    	if(consumer!=null){
    		consumer.shutdown();
    	}
    }
    
    public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public void setPartitionNum(Integer partitionNum) {
		this.partitionNum = partitionNum;
	}

	public static void main(String[] args) {
        new KafkaConsumer().consume();
    }
}