package com.sky.kafka.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import com.sky.kafka.impl.KafkaProducerImpl;
import com.sky.common.util.JacksonUtil;
import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.dao.model.MQOrderBean;
import com.sky.kafka.model.MemberLevel;
import com.sky.kafka.util.Util;
/**
 * 生产
 * @author dao
 *
 */
public class KafkaProducer{
	private static KafkaProducerImpl kafkaProducer;
	private static String TOPIC = "Order_MQ_Topic";
	private final static String location = "META-INF/spring/kafka-producer.properties";
	
	private KafkaProducer() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(location));
			kafkaProducer = new KafkaProducerImpl();
			kafkaProducer.setProperties(props);
			kafkaProducer.init();
		} catch (IOException e) {
		}
	}

	void produce(MQOrderBean mQOrderBean) {
		try{
			Random r = new Random();
			
				
				kafkaProducer.produce(TOPIC,JacksonUtil.toJson(mQOrderBean),r.nextInt(16)+"");
			
		}catch(Exception e){
			System.out.println("发送消息失败!");
		}finally{
			//
		}
		
	}
	
	void levelMember(int level)
	{
		MemberLevel memberLevel = new MemberLevel();
		
		String sql ="select member_id,order_id from member_level_20160101 where is_member =1 and level="+level+" order by pay_date";
		List<MemberLevel> mll =  JdbcTemplateDaoSupport.getList(sql, memberLevel);
		
		if(null == mll || mll.isEmpty())
		{
			return ;
		}
		for(MemberLevel ml : mll)
		{
			System.out.println(ml.toString());
			MQOrderBean mQOrderBean = new MQOrderBean();
			mQOrderBean.setMemberId(ml.getMemberId());
			mQOrderBean.setOrderId(ml.getOrderId());
			produce(mQOrderBean);
		}
	}
	
	public static void main(String[] args) {
		int level = 0;
		
		Util.getApplicationContext();
		
		try{
			level = Integer.parseInt(args[0]);
		}catch(Exception e){
			System.out.println("no level!");
			return;
		}
		
		
		new KafkaProducer().levelMember(level);
		
		kafkaProducer.destory();
	}
	
}