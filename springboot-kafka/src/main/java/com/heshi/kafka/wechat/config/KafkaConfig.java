package com.heshi.kafka.wechat.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description: TODO
 * @Author: fukun
 * @Date: 2020/6/17
 */
@Configuration
public class KafkaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public KafkaProducer kafkaProducer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.setProperty(ProducerConfig.ACKS_CONFIG, kafkaProperties.getAcks());
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, kafkaProperties.getRetries());
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProperties.getBatchSize());
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, kafkaProperties.getLingerMs());
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProperties.getBufferMemory());
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());

        return new KafkaProducer<String, String>(properties);
    }
}
