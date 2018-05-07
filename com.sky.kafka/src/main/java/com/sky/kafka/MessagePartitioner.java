package com.sky.kafka;

import java.util.Random;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @ClassName:MessagePartitioner.java
 * @Description:主题分区
 * @author: zenglinhua
 * @date: 2015-10-22
 */

public class MessagePartitioner implements Partitioner {
	
	public MessagePartitioner(VerifiableProperties props) {

	}
	
	/**
	 * (非 Javadoc) 
	* <p>Title: partition</p> 
	* <p>Description: </p> 
	* @param key
	* @param numPartitions
	* @return 
	* @see kafka.producer.Partitioner#partition(java.lang.Object, int)
	 */
	public int partition(Object key, int numPartitions) {
		/*if (key == null) {
			Random random = new Random();
			int result = random.nextInt(numPartitions);
			System.out.println("send to partition(key is null):" + result);
			return result;
		} else {
			int result = Math.abs(key.hashCode()) % numPartitions;
			System.out.println("send to partition(key is not null):" + result);
			return result;
		}*/
		Random random = new Random();
		int result = random.nextInt(numPartitions);
		return result;
	}
}
