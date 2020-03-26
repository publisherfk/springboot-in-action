package com.heshi.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.heshi.kafka.common.ErrorCode;
import com.heshi.kafka.common.MessageEntity;
import com.heshi.kafka.common.Response;
import com.heshi.kafka.producer.SimpleProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class  ProduceController {
    Logger logger = LoggerFactory.getLogger(ProduceController.class);
    @Autowired
    private SimpleProducer producer;
    @Value("${kafka.topic.default}")
    private String topic;

    @GetMapping("/send")
    public Response send(@RequestBody MessageEntity entity) {
        try {
            logger.info("kafka的消息={}", JSON.toJSON(entity));
            producer.send(topic, "key", entity);
            logger.info("kafka消息发送成功");
            return new Response(ErrorCode.SUCCESS, "消息发送成功");
        } catch (Exception e) {
            return new Response(ErrorCode.EXCEPTION, e.getMessage());
        }
    }
}
