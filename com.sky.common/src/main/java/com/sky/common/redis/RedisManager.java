package com.sky.common.redis;

import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import redis.clients.jedis.JedisCluster;

public class RedisManager {
	
	private Properties prop;
	private String addressKeyPrefix ;
	String msg = "toString() unavailable - no suspended threads";
	private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");
	// 0 - never expire
	private int expire = 0;
	
	//timeout for jedis try to connect to redis server, not expire time! In milliseconds
	private int timeout = 0;
	
	private String password = "";
	
//	@Autowired
//	private BinaryJedisCluster jedisClusterFactory;
	private JedisCluster jedisCluster;
	public RedisManager(){
	}
	
	/**
	 * 初始化方法
	 */
	public void init(){
//		if(jedisClusterFactorys==null){
//			try {
//
//				Set<HostAndPort> haps = new HashSet<HostAndPort>();
//				for (Object key : prop.keySet()) {
//
//					if (!((String) key).startsWith(addressKeyPrefix)) {
//						continue;
//					}
//
//					String val = (String) prop.get(key);
//
//					boolean isIpPort = p.matcher(val).matches();
//
//					if (!isIpPort) {
//						throw new IllegalArgumentException("ip 或 port 不合法");
//					}
//					String[] ipAndPort = val.split(":");
//
//					HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
//					haps.add(hap);
//				}
//				System.out.println("============================"+haps);
//				jedisCluster = new JedisCluster(haps,timeout);
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}  
//		}else{
//			try {
//				jedisCluster = jedisClusterFactorys;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
	

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getAddressKeyPrefix() {
		return addressKeyPrefix;
	}

	public void setAddressKeyPrefix(String addressKeyPrefix) {
		this.addressKeyPrefix = addressKeyPrefix;
	}

	public Pattern getP() {
		return p;
	}

	public void setP(Pattern p) {
		this.p = p;
	}

	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key){
		byte[] value = null;
			value = jedisCluster.get(key);
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value){
			jedisCluster.set(key,value);
		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value,int expire){
			jedisCluster.set(key,value);
			jedisCluster.expire(key, expire);
		return value;
	}
	
	/**
	 * del
	 * @param key
	 */
	public void del(byte[] key){
			jedisCluster.del(key);
	}
	
	/**
	 * flush
	 */
	public void flushDB(){
		System.out.println("flushDB");
//		Jedis jedis = jedisPoolWrite.getResource();
//		try{
//			jedisCluster.
//		}finally{
////			jedisPoolWrite.returnResource(jedis);
//		}
	}
	
	/**
	 * size
	 */
	public Long dbSize(){
		Long dbSize = 0L;
//		Jedis jedis = jedisPoolRead.getResource();
		try{
			dbSize = 500L;
		}finally{
//			jedisPoolRead.returnResource(jedis);
		}
		return dbSize;
	}

	/**
	 * keys
	 * @param pattern
	 * @return
	 */
	public Set<byte[]> keys(String pattern){
		Set<byte[]> keys = null;
		System.out.println("keys");
		try{
			keys = jedisCluster.hkeys(pattern.getBytes());
		}finally{
//			jedisPoolRead.returnResource(jedis);
		}
		return keys;
	}
	

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JedisCluster getJedisCluster() {
		return jedisCluster;
	}

	public void setJedisCluster(JedisCluster jedisCluster) {
		this.jedisCluster = jedisCluster;
	}
	
	
	
}
