package com.sky.common.profitUtil;



import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 并行计算框架
 * Created by zhangcp on 2016/5/9.14:28
 */
public class Executer {
    private static Logger log = Logger.getLogger(Executer.class);
    //存储任务的执行结果
    private List<Future<Object>> futres = new ArrayList<Future<Object>>();
    //条件队列锁,以及线程计数器
    public final Lock lock = new Lock();
    //线程池
    private ExecutorService pool = null;
    public Executer() {
        this(1);
    }
    public Executer(int threadPoolSize) {
        pool = Executors.newFixedThreadPool(threadPoolSize);
    }
    /**
     * 任务派发
     * @param job
     */
    public void fork(Job job){
        //设置同步锁
        job.setLock(lock);
        //将任务派发给线程池去执行
        futres.add(pool.submit(job));
        //增加线程数
        synchronized (lock) {
            lock.thread_count++;
        }
    }
    /**
     * 统计任务结果
     */
    public List<Object> join(){
        synchronized (lock) {
            while(lock.thread_count > 0){//检查线程数，如果为0，则表示所有任务处理完成

                try {
                    lock.wait();//如果任务没有全部完成，则挂起。等待完成的任务给予通知
                } catch (InterruptedException e) {
                    log.error("执行并行任务出错!" + e.getMessage() + Arrays.toString(e.getStackTrace()));
                }
            }
        }
        List<Object> list = new ArrayList<Object>();
        //取出每个任务的处理结果，汇总后返回
        for (Future<Object> future : futres) {
            try {
                Object result = future.get();//因为任务都已经完成，这里直接get
                if(result != null){
                    if(result instanceof List)
                        list.addAll((List)result);
                    else
                        list.add(result);
                }
            } catch (Exception e) {
                log.error("执行并行任务出错!" + e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        }
        return list;
    }
}