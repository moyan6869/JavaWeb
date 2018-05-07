package com.sky.log;

import kafka.consumer.ConsumerConfig;
import org.apache.log4j.Logger;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogMain {

    /**
     * 日志
     */
    private final static Logger log = Logger.getLogger(LogMain.class);

    /**
     * 线程数
     */
    private final static int THREAD_NUM = 10;

    /**
     * 线程池
     */
    private static ExecutorService fixedThreadPool;

    /**
     * 配置
     */
    private static ConsumerConfig config;

    /**
     * 出错的线程个数
     */
    private static int failThread = 0;

    /**
     * <p>
     * Title:构造方法
     * </p>
     * <p>
     * Description:设置私有以防被多次实例
     * </p>
     */
    private LogMain() {
        LogUtil.getApplicationContext();
        Properties props = (Properties) LogUtil.getApplicationContext().getBean("kafkaConsumerProperties");
        try {
            config = new ConsumerConfig(props);
        } catch (Exception e) {
            log.error("load Properties fail!", e);
        }
    }

    /**
     * @param @param args    设定文件
     * @return void    返回类型
     * @throws
     * @Title: main
     * @Description: 主函数入口
     */
    public static void main(String[] args) {
        new LogMain().run();
    }

    /**
     * @return void    返回类型
     * @throws
     * @Title: run
     * @Description: 开始执行线程
     */
    public void run() {
        fixedThreadPool = Executors.newFixedThreadPool(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            fixedThreadPool.execute(new LogConsumerThread(config, this));
        }
    }

    /**
     * @return void    返回类型
     * @throws
     * @Title: reportThreadFail
     * @Description: 报告线程失败
     */
    public void reportThreadFail() {
        //如果失败的线程达到开启的线程数，表示所有线程都异常，需要关闭线程池
        if (++failThread == THREAD_NUM) {
            fixedThreadPool.shutdown();
            log.error("fixedThreadPool shutdown!");
        }
    }
}
