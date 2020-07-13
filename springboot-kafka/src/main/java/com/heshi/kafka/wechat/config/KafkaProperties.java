package com.heshi.kafka.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author: fukun
 * @Date: 2020/6/17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wechat.kafka")
public class KafkaProperties {
    private String bootstrapServers = "10.10.90.169:9092";
    private String acks = "all";
    private String retries = "0";
    private String batchSize = "16384";
    private String lingerMs = "1";
    private String bufferMemory = "33554432";
    private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
    private String valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";
}
