package com.sky.common.redis;

import java.util.Set;

import com.sky.common.Constants;
import redis.clients.jedis.JedisCluster;

public class RedisClusterServer {
    //	JedisClusterFactory
    private JedisCluster jedisCluster;


    public RedisClusterServer() {
    }


    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }


    public JedisCluster getJedisCluster() {
//        if (jedisCluster == null) {
//            try {
//                jedisCluster = jedisClusterFactorys;
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
        return this.jedisCluster;
    }

//    
//    public JedisCluster getJedisClusterFactorys() {
//		return jedisClusterFactorys;
//	}
//
//
//	public void setJedisClusterFactorys(JedisCluster jedisClusterFactorys) {
//		this.jedisClusterFactorys = jedisClusterFactorys;
//	}


    /**
     * 将 key 所储存的值加上增量 increment
     *
     * @param key
     * @param value
     * @return
     */
    public long increment(String key, long value) {
        key= Constants.PRE_KEY+key;
        return getJedisCluster().incrBy(key, value);
    }
    /**
     * 自增加1
     *
     * @param key
     * @param value
     * @return
     */
    public long increment(String key) {
        key= Constants.PRE_KEY+key;
        return getJedisCluster().incr(key);
    }

    /**
     * 将 key 所储存的值减去减量 decrement
     *
     * @param key
     * @param value
     * @return
     */
    public long decrment(String key, long value) {
        key= Constants.PRE_KEY+key;
        return getJedisCluster().decrBy(key, value);
    }

    /**
     * 通过key删除（字节）
     *
     * @param key
     */
    public void del(byte[] key) {
        getJedisCluster().del(key);
    }

    /**
     * 通过key删除
     *
     * @param key
     */
    public void del(String key) {
//        key= Constants.PRE_KEY+key;
        getJedisCluster().del(key);
    }

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(byte[] key, byte[] value, int liveTime) {
        this.set(key, value);
        getJedisCluster().expire(key, liveTime);
    }

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, int liveTime) {
        this.set(key, value);
        getJedisCluster().expire(key, liveTime);
        //getJedisCluster().pexpire(key,liveTime);
        //getJedisCluster().expireAt(key,liveTime);
        //getJedisCluster().pexpireAt(key,liveTime);
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
//        key= Constants.PRE_KEY+key;
        getJedisCluster().set(key, value);
    }

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        getJedisCluster().set(key, value);
    }

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public String get(String key) {
//        key= Constants.SHIRO_LOGIN+key;
        String value = getJedisCluster().get(key);
        return value;
    }

    /**
     * 获取redis value (byte [] )(反序列化)
     *
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        return getJedisCluster().get(key);
    }

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        return getJedisCluster().hkeys(pattern);
    }

    /**
     * 检查key是否已经存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        key= Constants.PRE_KEY+key;
        return getJedisCluster().exists(key);
    }

    /**
     * 缓存对象  并设置有效时间
     *
     * @param key      key
     * @param object   对象
     * @param liveTime 有效时间 秒为单位

    public void setObject(byte[] key, Object object, int liveTime) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    getJedisCluster().set(key, ot.serialize(object));
    getJedisCluster().expire(key, liveTime);
    }
     */
    /**
     * 缓存对象
     *
     * @param key
     * @param object

    public void setObject(byte[] key, Object object) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    getJedisCluster().set(key, ot.serialize(object));
    }
     */
    /**
     * 获取对象
     *
     * @param key
     * @return

    public Object getObject(byte[] key) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    return ot.deserialize(getJedisCluster().get(key));
    }
     */

    /**
     * 缓存对象
     *
     * @param key
     * @param object

    public void setObject(String key, Object object) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    getJedisCluster().set(key.getBytes(), ot.serialize(object));
    }
     */
    /**
     * 获取对象
     *
     * @param key
     * @return

    public Object getObject(String key) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    return ot.deserialize(getJedisCluster().get(key.getBytes()));
    }
     */
    /**
     * 缓存对象  并设置有效时间
     *
     * @param key      key
     * @param object   对象
     * @param liveTime 有效时间 秒为单位

    public void setObject(String key, Object object, int liveTime) {
    ObjectsTranscoder ot = new ObjectsTranscoder();
    getJedisCluster().set(key.getBytes(), ot.serialize(object));
    getJedisCluster().expire(key.getBytes(), liveTime);
    }
     */

    /**
     * 缓存列表  并设置有效时间
     *
     * @param key      key
     * @param object   列表
     * @param liveTime 有效时间 秒为单位

    public void setList(byte[] key, Object object, int liveTime) {
    ListTranscoder lt = new ListTranscoder();
    getJedisCluster().set(key, lt.serialize(object));
    getJedisCluster().expire(key, liveTime);
    }
     */
    /**
     * 缓存列表
     *
     * @param key
     * @param object 列表

    public void setList(byte[] key, Object object) {
    ListTranscoder lt = new ListTranscoder();
    getJedisCluster().set(key, lt.serialize(object));
    }
     */
    /**
     * 获取列表
     *
     * @param key
     * @return

    public List<Object> getList(byte[] key) {
    ListTranscoder ot = new ListTranscoder();
    return ot.deserialize(getJedisCluster().get(key));
    }
     */
    /**
     * 缓存列表  并设置有效时间
     *
     * @param key      key
     * @param object   列表
     * @param liveTime 有效时间 秒为单位

    public void setList(String key, Object object, int liveTime) {
    ListTranscoder lt = new ListTranscoder();
    getJedisCluster().set(key.getBytes(), lt.serialize(object));
    getJedisCluster().expire(key.getBytes(), liveTime);
    }
     */
    /**
     * 缓存列表
     *
     * @param key
     * @param object 列表
    public void setList(String key, Object object) {
    ListTranscoder lt = new ListTranscoder();
    getJedisCluster().set(key.getBytes(), lt.serialize(object));
    }
     */
    /**
     * 获取列表
     *
     * @param key
     * @return

    public List<Object> getList(String key) {
    ListTranscoder ot = new ListTranscoder();
    return ot.deserialize(getJedisCluster().get(key.getBytes()));
    }
     */

    /**
     * 获取redis value (String)
     *
     * @param key
     * @return
     */
    public String getNotPreKey(String key) {
        String value = getJedisCluster().get(key);
        return value;
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void setNotPreKey(String key, String value) {
        getJedisCluster().set(key, value);
    }

    /**
     * 将 key 所储存的值加上增量 increment
     *
     * @param key
     * @param value
     * @return
     */
    public long incrementNotPreKey(String key, long value) {
        return getJedisCluster().incrBy(key, value);
    }

    /**
     * 通过key删除
     *
     * @param key
     */
    public void delNotPreKey(String key) {
        getJedisCluster().del(key);
    }
}
