package com.heshi.redis.sub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LiveChangeSub implements BaseSub {

    Logger logger = LoggerFactory.getLogger(LiveChangeSub.class);

    @Override
    public void receiveMessage(String jsonMessage) {
        logger.info(jsonMessage);
    }
}
