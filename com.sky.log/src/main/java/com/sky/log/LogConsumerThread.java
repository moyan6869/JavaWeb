/**
 * @Title: LogConsumerThread.java
 * @Package com.sibu.directSale.profit
 * @Description: 收益消费这线程类
 * @author zenglinhua
 * @date 2015年11月20日 下午3:23:13
 * @version V1.0
 */
package com.sky.log;

import java.util.List;

import org.apache.log4j.Logger;

import com.sky.common.util.JacksonUtil;
import com.sky.dao.log.BaseLogBean;
import com.sky.dao.log.DealLogBean;
import com.sky.dao.log.ProfitLogBean;
import com.sky.dao.log.SysLogBean;
import com.sky.dao.log.TradeLogBean;
import com.sky.dao.log.TransferFailureLogBean;
import com.sky.kafka.IKafkaConsumer;
import com.sky.log.service.BaseLogService;
import com.sky.log.service.DealLogService;
import com.sky.log.service.ProfitLogService;
import com.sky.log.service.SysLogService;
import com.sky.log.service.TradeLogService;
import com.sky.log.service.TransferFailureLogService;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.consumer.Whitelist;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * @Description: 日志功能
 */
public class LogConsumerThread implements Runnable, IKafkaConsumer {

    /**
     * 日志
     */
    private static Logger log = Logger.getLogger(LogConsumerThread.class);

    /**
     * 消费主题
     */
    public final static String TOPIC = "OrderLog_MQ_Topic";

    /**
     * kafka消费连接对象
     */
    private ConsumerConnector consumer;

    /**
     * 主进程对象
     */
    private LogMain logMain;

    /**
     * 系统日志服务
     */
    private BaseLogService sysLogService;

    /**
     * 收益日志服务
     */
    private BaseLogService profitLogService;

    /**
     * 提现日志服务
     */
    private BaseLogService dealLogService;

    /**
     * 交易日志服务
     */
    private BaseLogService tradeLogService;

    /**
     * 转帐失败日志服务
     */
    private TransferFailureLogService transferFailureLogService;

    /**
     * <p>Title: 构造方法</p>
     * <p>Description:构造方法 </p>
     *
     * @param config
     */
    public LogConsumerThread(ConsumerConfig config, LogMain logMain) {
        this.logMain = logMain;

        this.sysLogService = new SysLogService();
        this.profitLogService = new ProfitLogService();
        this.dealLogService = new DealLogService();
        this.tradeLogService = new TradeLogService();
        this.transferFailureLogService = new TransferFailureLogService();

        consumer = Consumer.createJavaConsumerConnector(config);
    }

    /**
     * (非 Javadoc)
     * <p>Title: run</p>
     * <p>Description: 启动线程</p>
     *
     * @see Runnable#run()
     */
    @Override
    public void run() {
        System.out.println(String.format("日志服务线程%d已启动", Thread.currentThread().getId()));

        log.info("启动线程,Thread ID:" + Thread.currentThread().getId() + ", Time:" + System.currentTimeMillis());
        //等待消息
        List<KafkaStream<byte[], byte[]>> kafkaStreamList = this.consumeList();
       
        try {
            for (KafkaStream<byte[], byte[]> kafkaStream : kafkaStreamList) {
                ConsumerIterator<byte[], byte[]> it = kafkaStream.iterator();
                while (it.hasNext()) {
                    MessageAndMetadata<byte[], byte[]> metaData = it.next();
                    byte[] bytes = metaData.message();
                   
                    BaseLogBean mqLog = JacksonUtil.fromJson(new String(bytes, "utf-8"), BaseLogBean.class);
                    if(null == mqLog)
                    {
                    	log.error("接收到无法辨识json");
                    	log.error(new String(bytes, "utf-8"));
                    }else {
                    	log.info(String.format("日志服务线程%d接收到消息%s", Thread.currentThread().getId(), mqLog.toString()));

                        this.WriteLog(mqLog);
					}
                    
                    this.commitOffsets();
                }
            }
        } catch (Exception e) {
            log.error("log thread fail!", e);
            this.destory();
            logMain.reportThreadFail();
        }
    }

    private void WriteLog(BaseLogBean baseLogBean) {
        if (baseLogBean instanceof SysLogBean) {
            sysLogService.WriteLog(baseLogBean);
        } else if (baseLogBean instanceof ProfitLogBean) {
            profitLogService.WriteLog(baseLogBean);
        } else if (baseLogBean instanceof DealLogBean) {
            dealLogService.WriteLog(baseLogBean);
        } else if (baseLogBean instanceof TradeLogBean) {
            tradeLogService.WriteLog(baseLogBean);
        } else if (baseLogBean instanceof TransferFailureLogBean) {
            transferFailureLogService.WriteLog(baseLogBean);
        } else {
            log.error(baseLogBean.toString());
        }
    }

    /**
     * (非 Javadoc)
     * <p>Title: consumeList</p>
     * <p>Description:消费消息 </p>
     *
     * @return
     * @see IKafkaConsumer#consumeList()
     */
    public List<KafkaStream<byte[], byte[]>> consumeList() {
        return this.consumeList(TOPIC);
    }

    /**
     * (非 Javadoc)
     * <p>Title: consumeList</p>
     * <p>Description:消费指定主题消息 </p>
     *
     * @param TOPIC
     * @return
     * @see IKafkaConsumer#consumeList(String)
     */
    @Override
    public List<KafkaStream<byte[], byte[]>> consumeList(String TOPIC) {
        Whitelist whitelist = new Whitelist(TOPIC);
        return consumer.createMessageStreamsByFilter(whitelist);
    }

    /**
     * (非 Javadoc)
     * <p>Title: commitOffsets</p>
     * <p>Description: Commit the offsets of all broker partitions connected by this connector.</p>
     *
     * @see IKafkaConsumer#commitOffsets()
     */
    @Override
    public void commitOffsets() {
        if (null != consumer) {
            consumer.commitOffsets();
        }
    }

    /**
     * (非 Javadoc)
     * <p>Title: destory</p>
     * <p>Description:Shut down the connector </p>
     *
     * @see IKafkaConsumer#destory()
     */
    @Override
    public void destory() {
        if (null != consumer) {
            consumer.shutdown();
        }
    }

}
