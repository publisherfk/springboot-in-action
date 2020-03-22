package com.heshi.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisMessageSub {
    Logger logger = LoggerFactory.getLogger(RedisMessageSub.class);

    public void onMessage(String message) {
        logger.info("channel: {}, message:{}", "channel1", message);
    }
}
