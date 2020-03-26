package com.heshi.redis.controller;

import com.heshi.redis.service.RedisValueTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/base/redis/value")
public class RedisValueTestController {
    @Autowired
    private RedisValueTestService valueTestService;

    @PutMapping("/set1")
    public void set(String key, String value) {
        valueTestService.set(key, value);
    }

    @PutMapping("/set2")
    public void set(String key, String value, long timeout) {
        valueTestService.set(key, value, timeout, TimeUnit.SECONDS);
    }

    @PutMapping("/set3")
    public void set(String key, String value, Duration duration) {
        valueTestService.set(key, value, duration);
    }

    @GetMapping("/get")
    public Object get(String key) {
        return valueTestService.get(key);
    }
}
