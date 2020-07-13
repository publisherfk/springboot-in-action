package com.heshi.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProducerSample {

    public final static String TOPIC_NAME = "kafka-topic-heshi3";

    /**
     * 异步发送
     *
     * @param count
     */
    public static void producerSend(int count) {
        Producer<String, String> producer = producer();
        for (int i = 0; i < count; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, "key-" + i, "value-" + i);
            producer.send(producerRecord);
        }
        producer.close();
    }

    /**
     * 同步发送
     *
     * @param count
     */
    public static void producerSyncSend(int count) {
        Producer<String, String> producer = producer();
        for (int i = 0; i < count; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, "key-" + i, "value-" + i);
            Future<RecordMetadata> send = producer.send(producerRecord);
            RecordMetadata recordMetadata = null;
            try {
                recordMetadata = send.get();
                System.out.println("key-" + i + ",partition:" + recordMetadata.partition() + ",offset" + recordMetadata.offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }

    /**
     * 同步发送 带callback
     *
     * @param count
     */
    public static void producerSendWithCallBack(int count) {
        Producer<String, String> producer = producer();
        for (int i = 0; i < count; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME, "key-" + i, "value-" + i);
            producer.send(producerRecord, (metadata, exception) -> {
                System.out.println("send message offset is:" + metadata.offset());
            });
        }
        producer.close();
    }

    /**
     * @returnp
     */
    public static Producer producer() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, "0");
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "1");
        properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, "33554432");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<String, String>(properties);
    }

    public static void main(String[] args) {
        producerSend(100);
    }
}
