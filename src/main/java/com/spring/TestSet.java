package com.spring;

import redis.clients.jedis.Jedis;

/**
 * @author When all else is lost the future still remains.
 * @date 2021/2/5 - 17:13
 **/
public class TestSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        String key = "eleSet";
        System.out.println("============向集合中添加元素(不能重复)================");
        System.out.println(jedis.sadd(key, "w1", "w2", "w3", "w4", "w5"));
        System.out.println("eleSet的所有元素" + jedis.smembers(key));
        System.out.println("eleSet的包含元素的个数:" + jedis.scard(key));
        System.out.println("判断eleSet是否存在元素e3" + jedis.sismember(key, "e3"));
        System.out.println("=================新增key2=============");
        String key2 = "eleSet2";
        System.out.println(jedis.sadd(key2, "e1", "e2", "e3", "e4", "w1", "w3", "w4"));
        System.out.println("将eleSet1中的元素e1删除，并入到eleSet2中" + jedis.smove(key, key2, "w2"));
        System.out.println("打印key中的元素" + jedis.smembers(key));
        System.out.println("打印key2中的元素" + jedis.smembers(key2));


        System.out.println("================集合运算==================");
        System.out.println("key中的元素" + jedis.smembers(key));
        System.out.println("key2中的元素" + jedis.smembers(key2));
        System.out.println("key和key2的交集" + jedis.sinter(key, key2));
        System.out.println("key和key2的并集" + jedis.sunion(key, key2));
        System.out.println("key和key2的差集" + jedis.sdiff(key, key2));

        String key3 = "eleSet3";
        jedis.sinterstore(key3, key, key2); //求交集并将交集保存到dstkey集合
        System.out.println("key3中的元素" + jedis.smembers(key3));

    }


}
