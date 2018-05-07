package com.sky.common.profitUtil;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * 抽象任务
 * Created by zhangcp on 2016/5/9.14:30
 */
public abstract class Job implements Callable<Object> {
    private static Logger log = Logger.getLogger(Job.class);
    //锁
    private Lock lock = null;

    void setLock(Lock lock) {
        this.lock = lock;
    }

    public Object call() throws Exception {
        Object result = null;
        try{
            result = this.execute();//执行子类具体任务
        }catch(Exception e){
            log.error("执行并行任务出错!" + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        synchronized (lock) {
            //处理完业务后，任务结束，递减线程数，同时唤醒主线程
            lock.thread_count--;
            lock.notifyAll();
        }
        return result;
    }
    /**
     * 业务处理函数
     */
    public abstract Object execute();

}

class Lock {
    //线程数
    int thread_count;

}