package com.heshi.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class RedisHashTestService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入指定的hash对象key 和map输入
     *
     * @param key
     * @param valueKey
     * @param value
     */
    public void redisAdd(String key, String valueKey, String value) {
        redisTemplate.boundHashOps(key).put(valueKey, value);
    }

    public void redisAddLong(String key, String valueKey, long value) {
        redisTemplate.boundHashOps(key).put(valueKey, value);
    }

    /**
     * 根据指定的hash对象key,和键值对的key，获取对应的value
     *
     * @param key
     * @param valueKey
     * @return
     */
    public Object redisGet(String key, String valueKey) {
        return redisTemplate.boundHashOps(key).get(valueKey);
    }

    /**
     * 根据指定的hash对象key,删除指定的键值对key
     *
     * @param key
     * @param valueKeys
     * @return
     */
    public Object redisDelete(String key, Object... valueKeys) {
        return redisTemplate.boundHashOps(key).delete(valueKeys);
    }

    /**
     * 获取指定的hash对象key里面所有的hash对象
     *
     * @param key
     * @return
     */
    public Map redisEntries(String key) {
        return redisTemplate.boundHashOps(key).entries();
    }

    /**
     * 根据指定的hash对象key,判断指定的键值对key是否存在
     *
     * @param key
     * @param valueKey
     * @return
     */
    public Boolean redisHasKey(String key, Object valueKey) {
        return redisTemplate.boundHashOps(key).hasKey(valueKey);
    }

    /**
     * 根据指定的hash对象key和键值对的key集合，返回对应的map
     *
     * @param key
     * @param valueKeys
     * @return
     */
    public List redisMultiGet(String key, Collection valueKeys) {
        return redisTemplate.boundHashOps(key).multiGet(valueKeys);
    }

    /**
     * 根据指定的hash对象key和键值对的key,自增量delta，返回自增后的值
     *
     * @param key
     * @param valueKey
     * @param delta
     * @return
     */
    public Long redisIncrement(String key, String valueKey, long delta) {
        return redisTemplate.boundHashOps(key).increment(valueKey, delta);
    }
}
