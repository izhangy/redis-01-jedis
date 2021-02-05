package com.spring;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author When all else is lost the future still remains.
 * @date 2021/2/5 - 15:45
 **/
public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("清空数据:" + jedis.flushDB());
        System.out.println("判断某个键是否存在" + jedis.exists("key"));
        System.out.println("新增<'key', 'value'>的键值对：" + jedis.set("key", "value"));
        System.out.println("新增<'key1', 'value1'>的键值对" + jedis.set("key1", "value1"));
        System.out.println("获取系统中所有的键");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键key" + jedis.del("key"));
        System.out.println("判断键key是否存在" + jedis.exists("key"));
        System.out.println("查看value所存储的值的类型" + jedis.type("value"));
        System.out.println("随机返回key空间的一个" + jedis.randomKey());
        System.out.println("重命名key" + jedis.rename("key", "revalue"));
        System.out.println("取出重命名后的revalue" + jedis.get("revalue"));
        System.out.println("按索引查询：" + jedis.select(0));
        System.out.println("删除当前选择的数据库中所有的key" + jedis.flushDB());
        System.out.println("返回当前数据库中key的数目" + jedis.dbSize());
        System.out.println("删除所有数据库中的所有key" + jedis.flushAll());

    }

}
