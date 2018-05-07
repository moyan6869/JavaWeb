package com.sky.kafka;
import com.sky.common.util.JacksonUtil;
import com.sky.dao.log.DealLogBean;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.dao.model.MQOrderBean;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner. class)
@ContextConfiguration(locations = {"classpath:META-INF/spring/kafka-producer-context.xml"})
public class KakaProducerTest extends Assert{
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private IKafkaProducer doingOrderProducer;

    //@Autowired
    //private IKafkaProducer doingOrderLogProducer;
	
	@Test
	public void producerTest() {
		int messageNo = 0;
        final int COUNT = 1;
        String TOPIC = "Order_MQ_Topic";
        MQOrderBean mQOrderBean = null;
        while (messageNo < COUNT) {
        	
        	mQOrderBean = new MQOrderBean();
        	mQOrderBean.setMemberId("-1");
        	mQOrderBean.setOrderId("-1");
            
            doingOrderProducer.produce(TOPIC,JacksonUtil.toJson(mQOrderBean),String.valueOf(messageNo));
            messageNo ++;
        }
        doingOrderProducer.destory();
	}

    @Test
    public void producerTest2() {
        int messageNo = 0;
        final int COUNT = 10;
        String TOPIC = "OrderLog_MQ_Topic";
        while (messageNo < COUNT) {
           
            DealLogBean dealLogBean = new DealLogBean();
            dealLogBean.setLogId(messageNo);
            dealLogBean.setLogData("DealLog");
            dealLogBean.setMemberId("12345678");
            dealLogBean.setCreateDate(new Date());

            //messageBean.setContent(dealLogBean);
           // doingOrderLogProducer.produce(TOPIC,JacksonUtil.toJson(dealLogBean),String.valueOf(messageNo));
            messageNo ++;
        }
        doingOrderProducer.destory();
    }
}
