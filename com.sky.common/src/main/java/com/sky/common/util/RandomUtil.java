package com.sky.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 根据当前时间戳，生成随机+顺序值
 * Created by wangyun on 2015/11/27.
 */

public class RandomUtil {
    public static final long dx = 30 * 386 * 12 * 30 * 24 * 3600 * 1000; // starting at 2000 year
    public static long lastUUID = System.currentTimeMillis() - dx;

    public static synchronized long random() {
        long uuid = System.currentTimeMillis() - dx;
        while (uuid == lastUUID)
            uuid = System.currentTimeMillis() - dx;
        lastUUID = uuid;
        return uuid;
    }

    public static void main(String[] args) {
        Map numbers = new HashMap<Long, Long>();
        long value = 0;

        int max = 10000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            value = RandomUtil.random();
            numbers.put(value, value);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(String.format("生成%d，耗时%d毫秒", max, time));//生成10000，耗时11457毫秒

        Iterator iter = numbers.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();

            System.out.println(key + "=" + val);
        }
    }

}
