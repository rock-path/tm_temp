package com.psh.utils;

import com.psh.config.SpringContextHolder;
import com.psh.config.StaticConfig;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class RedisTemplateUtils {


    private static RedisTemplate<String, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");


    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value,10*60, TimeUnit.SECONDS);
    }

    public static void expire(String key) {
        redisTemplate.expire(key, 10*60 , TimeUnit.SECONDS);
    }

}
