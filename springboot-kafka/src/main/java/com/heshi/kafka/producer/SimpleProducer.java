package com.heshi.kafka.producer;

import com.heshi.kafka.common.MessageEntity;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class SimpleProducer {
    @Autowired
    private KafkaTemplate<String, MessageEntity> kafkaTemplate;

    public void send(String topic, MessageEntity messageEntity) {
        kafkaTemplate.send(topic, messageEntity);
    }

    public void send(String topic, String key, MessageEntity messageEntity) {
        ProducerRecord<String, MessageEntity> producerRecord = new ProducerRecord<>(topic, key, messageEntity);
        Long currentTime = System.currentTimeMillis();
        ListenableFuture<SendResult<String, MessageEntity>> future = kafkaTemplate.send(producerRecord);
        future.addCallback(new ProducerCallback(currentTime, key, messageEntity));
    }
}
