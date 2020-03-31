package com.heshi.redis.controller;

import com.heshi.redis.service.RedisSetTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fukun
 * @Date: 2020/3/30 10:34
 * @since
 */
@RestController
@RequestMapping("/base/redis/value")
public class RedisSetTestController {
    @Autowired
    private RedisSetTestService redisSetTestService;

    @PutMapping("/set")
    public void set() {
        redisSetTestService.members();
    }
}
