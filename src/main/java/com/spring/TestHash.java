package com.spring;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author When all else is lost the future still remains.
 * @date 2021/2/7 - 14:14
 **/
public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String key = "hashKey";
        jedis.flushDB();
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        //添加键值为hashKey的hash元素
        jedis.hmset(key, map);
        //向名称为hashKey的hash中添加键值对
        String key1 = "key5";
        jedis.hset(key, key1, "value5");
        System.out.println("打印所有散列的键值对" + jedis.hgetAll(key));
        System.out.println("打印所有散列的键" + jedis.hkeys(key));
        System.out.println("打印所有值" + jedis.hvals(key));
        System.out.println("将key6保存的值添加整数，如果key6不存在，则添加key6: " + jedis.hincrBy(key, "key6", 100));
        System.out.println("打印所有散列的键值对" + jedis.hgetAll(key));
        System.out.println("删除一个或者多个键值对 ：" + jedis.hdel(key, "key2"));
        System.out.println("获取散列中键值对的个数" + jedis.hlen(key));
        System.out.println("判断key中是否存在key2" + jedis.hexists(key, "key2"));
        System.out.println("获取key中元素key3的值" + jedis.hmget(key, "key3"));

    }
}
