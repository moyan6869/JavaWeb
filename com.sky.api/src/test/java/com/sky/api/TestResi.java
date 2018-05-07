package com.sky.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.util.SafeEncoder;

public class TestResi {
	public static JedisCluster jedisCluster;
   public static void main( String[] args	){
    Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
    jedisClusterNode.add(new HostAndPort("120.76.65.235", 6379));
    jedisClusterNode.add(new HostAndPort("120.76.76.90", 6379));
    jedisClusterNode.add(new HostAndPort("120.76.43.202", 6379));
//    jedisClusterNode.add(new HostAndPort("47.89.28.35", 6379));
//    jedisClusterNode.add(new HostAndPort("47.89.28.63", 6379));
//    jedisClusterNode.add(new HostAndPort("47.89.28.37", 6379));
    JedisCluster jedisCluster = new JedisCluster(jedisClusterNode);
    Set<String> ss = null;
    Map<String, String> ssl = null;
    List<String> list = null;
    list = jedisCluster.mget("phone1_*");
    Map<String, JedisPool> map = jedisCluster.getClusterNodes();
    for(String keys:map.keySet()){
//    	String memberStr = ssl.get(keys);
    	JedisPool jp = map.get(keys);
    	Jedis jsd = jp.getResource();
    	ss = jsd.keys("phone1_*");
    	Iterator<String> it = ss.iterator();  
    	while (it.hasNext()) {  
    	  String str = it.next();  
    	  System.out.println(str);  
    	} 
    }
//    jedisCluster
//    MemberBean mb = new MemberBean();
//    mb.setCreateDate(new Date());
//    mb.setUpdateDate(new Date());
//    mb.setCommentType(1);
//    mb.setMemberId("aaea21994fb5455684bbe505e8ea3ec7");
//    mb.setPhone("13800013800");
//    mb.setPassword("d81a0bf94ca0ad5ccc6a292e550f076b");
//    mb.setNickName("顶级用户");
//    mb.setSalt("9416ead297af18642a44585a5453e64b");
//    mb.setWechatOpenId("testtest12345678123");
//    mb.setWechatUnionId("123123123123123123123");
//    mb.setReferrerMemberId("0");
//    mb.setDeleteFlag(0);
//    mb.setInviteCode(100061L);
//    String msgs = jedisCluster.set(Constants.REDIS_INVITA+"100192",mb.getMemberId());
//    
//    jedisCluster.set(mb.getMemberId(), JacksonUtil.toJson(mb));
//    MemberBean stroo = JacksonUtil.fromJson(jedisCluster.get(mb.getMemberId())+"",MemberBean.class);
//    System.out.println(stroo.getMemberId());
//  	 jedis.clusterSetSlotMigrating(slot, nodeId)
   }

  
  public static byte[] get1(byte[] key) {
		String value = "";
		if(jedisCluster!=null){
			value = jedisCluster.get(SafeEncoder.encode(key));
		}
		if(value!=null&&!value.equals("")){
			return SafeEncoder.encode(value);
		}
		return null;
	}
	
	public static String set1(byte[] key,byte[] value){
		String msg = "";
		if(jedisCluster!=null){
			msg = jedisCluster.set(SafeEncoder.encode(key),SafeEncoder.encode(value));
		}
		return msg;
	}
	public void del(byte[] key){
		jedisCluster.del(SafeEncoder.encode(key));
	}
}
