package com.heshi.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class RedisValueTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.boundValueOps(key).set(value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisTemplate.boundValueOps(key).set(value, timeout, timeUnit);
    }

    public void set(String key, String value, Duration duration) {
        redisTemplate.boundValueOps(key).set(value, duration);
    }

    public Object get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }
}
