package com.heshi.redis.pub;

import com.heshi.redis.common.BasePubMessage;
import com.heshi.redis.common.RedisChannelEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisPubImpl implements RedisPub {

    Logger logger = LoggerFactory.getLogger(RedisPubImpl.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void sendMessage(RedisChannelEnums redisChannelEnums, BasePubMessage basePubMessage) {
        if (redisChannelEnums != null && basePubMessage != null) {
            basePubMessage.setChannel(redisChannelEnums.getCode());
            redisTemplate.convertAndSend(redisChannelEnums.getCode(), basePubMessage);
            if (logger.isDebugEnabled()) {
                logger.debug("pub message:{}", basePubMessage);
            }
        }
    }
}
