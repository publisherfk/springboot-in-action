package com.heshi.redis.sub;

public interface BaseSub {
    /**
     * 接收消息
     *
     * @param jsonMessage
     */
    void receiveMessage(String jsonMessage);
}

