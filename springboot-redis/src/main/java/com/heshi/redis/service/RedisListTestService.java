package com.heshi.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisListTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void set(String key) {
    }
}
