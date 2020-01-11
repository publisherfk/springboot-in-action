package com.heshi.redis.pub;

import com.heshi.redis.common.BasePubMessage;
import com.heshi.redis.common.RedisChannelEnums;

public interface RedisPub {
    void sendMessage(RedisChannelEnums redisChannelEnums, BasePubMessage basePubMessage);
}
