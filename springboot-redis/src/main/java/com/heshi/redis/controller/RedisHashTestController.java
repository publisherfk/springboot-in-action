package com.heshi.redis.controller;

import com.heshi.redis.service.RedisHashTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/base/redis/hash")
public class RedisHashTestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisHashTestService redisTestService;

    @PostMapping("/add")
    public void redisAdd(String key, String valueKey, String value) {
        redisTestService.redisAdd(key, valueKey, value);
    }

    @PostMapping("/addLong")
    public void addLong(String key, String valueKey, long value) {
        redisTestService.redisAddLong(key, valueKey, value);
    }

    @GetMapping("/get")
    public Object redisGet(String key, String valueKey) {
        Object object = redisTestService.redisGet(key, valueKey);
        logger.info(object.getClass().toString());
        return redisTestService.redisGet(key, valueKey);
    }

    @DeleteMapping("/delete")
    public Object redisDelete(String key, String valueKey) {
        return redisTestService.redisDelete(key, valueKey);
    }

    @PutMapping("/increment")
    public Object redisIncrement(String key, String valueKey, long delta) {
        return redisTestService.redisIncrement(key, valueKey, delta);
    }

    @GetMapping("/multiGet")
    public Object redisMultiGet(String key) {
        List<String> keys = new ArrayList() {{
            add("aa");
            add("bb");
        }};
        List<Map> result = redisTestService.redisMultiGet(key, keys);
        return result.stream().filter(map -> null != map).collect(Collectors.toList()).size();
    }
}
