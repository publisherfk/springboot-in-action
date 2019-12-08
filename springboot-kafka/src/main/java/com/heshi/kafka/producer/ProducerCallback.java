package com.heshi.kafka.producer;

import com.alibaba.fastjson.JSON;
import com.heshi.kafka.common.MessageEntity;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Objects;

public class ProducerCallback implements ListenableFutureCallback<SendResult<String, MessageEntity>> {
    private Long startTime;
    private String key;
    private MessageEntity messageEntity;
    Logger logger = LoggerFactory.getLogger(ProducerCallback.class);

    public ProducerCallback(Long startTime, String key, MessageEntity messageEntity) {
        this.startTime = startTime;
        this.key = key;
        this.messageEntity = messageEntity;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MessageEntity getMessageEntity() {
        return messageEntity;
    }

    public void setMessageEntity(MessageEntity messageEntity) {
        this.messageEntity = messageEntity;
    }

    @Override
    public void onFailure(Throwable ex) {

    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> result) {
        if (Objects.isNull(result)) {
            return;
        }
        Long currentTime = System.currentTimeMillis() - startTime;
        RecordMetadata metadata = result.getRecordMetadata();
        if (Objects.nonNull(metadata)) {
            StringBuilder builder = new StringBuilder();
            builder.append("message(")
                    .append("key = ").append(key).append(",")
                    .append("message = ").append(JSON.toJSON(messageEntity)).append(")")
                    .append("sent to partition(").append(metadata.partition()).append(")")
                    .append("with offset(").append(metadata.offset()).append(")")
                    .append("in ").append(currentTime).append(" ms");
            logger.info(metadata.toString());
        }
    }
}
