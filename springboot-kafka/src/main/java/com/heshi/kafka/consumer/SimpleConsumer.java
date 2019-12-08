package com.heshi.kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.heshi.kafka.common.MessageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {
    Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);

    @KafkaListener(topics = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity messageEntity) {
        logger.info(JSON.toJSON(messageEntity).toString());
    }
}
