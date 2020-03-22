package com.heshi.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisChannelTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void send(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
