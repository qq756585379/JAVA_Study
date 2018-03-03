package com.itheima.test;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class jedisClient {

    @Test
    public void jedisClient() {
        // Jedis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 通过redis赋值
        jedis.set("s2", "222");
        // 通过redis取值
        String result = jedis.get("s2");
        System.out.println(result);
        // 关闭jedis
        jedis.close();
    }

    @Test
    public void jedisPool() {
        // JedisPool
        JedisPool pool = new JedisPool("127.0.0.1", 6379);
        // 通过连接池获取jedis对象
        Jedis jedis = pool.getResource();
        jedis.set("s4", "444");

        String result = jedis.get("s3");
        System.out.println(result);
        // 关闭jedis客户端
        jedis.close();
        // 关闭连接池
        pool.close();
    }

    @Test
    public void jedisCluster() {
        // 创建jedisCluster
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.242.137", 7001));
        nodes.add(new HostAndPort("192.168.242.137", 7002));
        nodes.add(new HostAndPort("192.168.242.137", 7003));
        nodes.add(new HostAndPort("192.168.242.137", 7004));
        nodes.add(new HostAndPort("192.168.242.137", 7005));
        nodes.add(new HostAndPort("192.168.242.137", 7006));
        nodes.add(new HostAndPort("192.168.242.137", 7007));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("s4", "444");

        String result = cluster.get("s4");
        System.out.println(result);

        cluster.close();
    }
}