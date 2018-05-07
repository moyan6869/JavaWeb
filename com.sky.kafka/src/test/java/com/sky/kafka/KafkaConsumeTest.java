package com.sky.kafka;



import java.util.List;

import junit.framework.Assert;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner. class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/kafka-consumer-context.xml"})
public class KafkaConsumeTest extends Assert {
	protected Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private IKafkaConsumer doingOrderLogConsumer;
	
	@Test
	public void consumerListTest() {
		String TOPIC= "OrderLog_MQ_Topic";
		List<KafkaStream<byte[], byte[]>> partitions = doingOrderLogConsumer.consumeList(TOPIC);
		for (KafkaStream<byte[], byte[]> partition : partitions) {  
			ConsumerIterator<byte[], byte[]> it = partition.iterator();
	        while (it.hasNext()){
	            StringBuffer sb = new StringBuffer();
	            MessageAndMetadata<byte[], byte[]> metaData = it.next();
	     	    byte[] bytes = metaData.message();
	     	    //MessageBean mb = (MessageBean) BeanUtils.bytes2Object(bytes);
	     	    sb.append("Part: " + metaData.partition() + " ");
	     	    sb.append("Key: " + metaData.key() + " ");
	     	   // sb.append("tm: " + mb.getDatetimes()+ " ");
	     	   // sb.append("Message: " + mb.getContent());
	     	    System.err.println(sb.toString());
                doingOrderLogConsumer.commitOffsets();
	        }
		}
		
	}
	
	@Test
	public void defConsumerTest() {
		List<KafkaStream<byte[], byte[]>> partitions = doingOrderLogConsumer.consumeList();
		for (KafkaStream<byte[], byte[]> partition : partitions) {  
			ConsumerIterator<byte[], byte[]> it = partition.iterator();
	        while (it.hasNext()){
	            StringBuffer sb = new StringBuffer();
	            MessageAndMetadata<byte[], byte[]> metaData = it.next();
	     	    byte[] bytes = metaData.message();
	     	    //MessageBean mb = (MessageBean) BeanUtils.bytes2Object(bytes);
	     	    sb.append("Part: " + metaData.partition() + " ");
	     	    sb.append("Key: " + metaData.key() + " ");
	     	   // sb.append("tm: " + mb.getDatetimes()+ " ");
	     	   // sb.append("Message: " + (String)((MessageBean)mb.getContent()).getContent()+ " ");
	     	    System.err.println(sb.toString());
                doingOrderLogConsumer.commitOffsets();
	        }
		}
	}
}