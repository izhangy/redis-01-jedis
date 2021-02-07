package com.spring;

import redis.clients.jedis.Jedis;

/**
 * @author When all else is lost the future still remains.
 * @date 2021/2/5 - 15:19
 **/
public class JedisConfigTest {
    public static void main(String[] args) {
        //1. new jedis对象
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //客户端启动redis方式:redis-server.exe redis.windows.conf
        //2. jedis命令
        System.out.println(jedis.ping());


    }
}

