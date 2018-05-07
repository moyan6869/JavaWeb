package com.sky.api;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import com.sky.common.util.serialize.ObjectsTranscoder;
import com.sky.dao.vo.AddressBean;

public class TestSe {
    private static JedisCluster jedisCluster;

    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("120.25.63.159", 6379));
        jedisClusterNode.add(new HostAndPort("120.25.62.63", 6379));
        jedisClusterNode.add(new HostAndPort("120.25.61.43", 6379));
        jedisCluster = new JedisCluster(jedisClusterNode);

        AddressBean bs = new AddressBean();
        bs.setAddressid(1);
        bs.setAddressname("sdfsdf");
        ObjectsTranscoder<AddressBean> sb = new ObjectsTranscoder<AddressBean>();
        jedisCluster.set("abc".getBytes(), sb.serialize(bs));
        AddressBean bss = new AddressBean();
        bss = (AddressBean) sb.deserialize(jedisCluster.get("abc".getBytes()));
        System.out.println(bss.getAddressid());
        String bb = "sdfsdasssf";
        ObjectsTranscoder sb1 = new ObjectsTranscoder();
        jedisCluster.set("absssc", "sdfsdf");
        System.out.println(jedisCluster.get("absssc"));
    }
}
