package com.heshi.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisSetTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.boundSetOps(key).add(value);
    }

    public void members () {
        Set<String> modules = redisTemplate.opsForSet().members("unAuthModule");
        String aa = "";
    }
}
