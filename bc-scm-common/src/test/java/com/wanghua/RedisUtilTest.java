package com.beautifulchina;

import com.beautifulchina.exception.RedisException;
import com.beautifulchina.manager.RedisManager;

/**
 * Created by chenghuanhuan on 15/10/12.
 */
public class RedisUtilTest {
    public static void main(String[] args)
    {
        RedisManager redisUtil = com.beautifulchina.TestBeanFactory.getInstance(RedisManager.class);
        System.out.println("-------------");
        System.out.println(redisUtil);

        try {
            long l = redisUtil.hset("test","a","b");
            String s =redisUtil.hget("test","a");
            System.out.println(s);
        } catch (RedisException e) {
            e.printStackTrace();
        }
    }
}
