package com.heshi.kafka.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author: fukun
 * @Date: 2020/6/18
 */
public class ConsumerSample {
    public final static String TOPIC_NAME = "kafka-topic-heshi3";

    public static void consumerMsg(String... topicName) {
        KafkaConsumer consumer = consumer();
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("partition = %d, offset = %d, key = %s, value = %s", record.partition(), record.offset(), record.key(), record.value());
                System.out.println("");
            }
            consumer.commitAsync();
        }
    }

    /**
     * 单个partition
     *
     * @param topicName
     */
    public static void consumerMsgSinglePartition(String... topicName) {
        KafkaConsumer consumer = consumer();
        consumer.subscribe(Arrays.asList(topicName));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            records.partitions().forEach(partition -> {
                records.records(partition).forEach(record -> {
                    System.out.printf("partition = %d, offset = %d, key = %s, value = %s", record.partition(), record.offset(), record.key(), record.value());
                    System.out.println("");
                });
                long lastOffSet = records.records(partition).get(records.records(partition).size() - 1).offset();
                Map<TopicPartition, OffsetAndMetadata> offset = new HashMap<>();
                offset.put(partition, new OffsetAndMetadata(lastOffSet + 1));
                consumer.commitSync(offset);
            });
        }
    }

    /**
     * @return
     */
    public static KafkaConsumer consumer() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "test");
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//        properties.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer consumer = new KafkaConsumer<String, String>(properties);
        return consumer;
    }

    public static void main(String[] args) {
        consumerMsgSinglePartition(TOPIC_NAME);
    }
}
