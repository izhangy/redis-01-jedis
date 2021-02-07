package com.spring;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author When all else is lost the future still remains.
 * @date 2021/2/7 - 14:46
 **/

/**
 * Redis中事务的操作
 *
 */

public class TestTranactional {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        JSONObject object = new JSONObject();
        object.put("hello", "redis");
        object.put("age", "0.5");
        //开启事务
        Transaction multi = jedis.multi();
        String result = object.toJSONString();

        jedis.watch(result);
        try {
            multi.set("user1", result);
            multi.set("user2", result);
            multi.exec();  //执行事务
        } catch (Exception e) {
            multi.discard(); //放弃事务
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();  //关闭连接
        }

    }
}
