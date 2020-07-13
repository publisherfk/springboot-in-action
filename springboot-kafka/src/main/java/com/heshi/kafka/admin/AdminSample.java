package com.heshi.kafka.admin;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.ConfigResource;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class AdminSample {

    public final static String TOPIC_NAME = "kafka-topic-heshi3";

    /**
     * 设置AdminClient
     *
     * @return
     */
    public static AdminClient adminClient() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "10.10.90.169:9092");
        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }

    /**
     * 创建topic实例
     */
    public static void createTopic() {
        AdminClient adminClient = adminClient();
        //副本因子
        Short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, rs);
        CreateTopicsResult createTopicsResult = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("CreateTopicsResult: " + createTopicsResult.values());
    }

    /**
     * 列出当前的topic
     */
    public static void topicLists() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        listTopicsResult.names().get().stream().forEach(System.out::println);
    }

    /**
     * 删除topic
     */
    public static void delTopic() {
        AdminClient adminClient = adminClient();
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList(TOPIC_NAME));
        deleteTopicsResult.all();
    }

    /**
     * 描述topic
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void describeTopic() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        DescribeTopicsResult describeTopicsResult = adminClient.describeTopics(Arrays.asList(TOPIC_NAME));
        describeTopicsResult.all().get().entrySet().stream().forEach(entry -> {
            System.out.println("name:" + entry.getKey() + ",desc:" + entry.getValue());
        });
    }

    /**
     * 描述配置信息
     */
    public static void describeConfig() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, TOPIC_NAME);
        DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(Arrays.asList(configResource));
        describeConfigsResult.all().get().entrySet().stream().forEach(entry -> {
            System.out.println("name:" + entry.getKey() + ",desc:" + entry.getValue());
        });
    }

    /**
     * 修改配置信息
     */
    public static void alterConfig() throws ExecutionException, InterruptedException {
        AdminClient adminClient = adminClient();
        ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, TOPIC_NAME);
        ConfigEntry entry = new ConfigEntry("preallocate", "false");
        Map<ConfigResource, Collection<AlterConfigOp>> configMaps = new HashMap<>();
        AlterConfigOp config = new AlterConfigOp(entry, AlterConfigOp.OpType.SET);
        configMaps.put(configResource, Arrays.asList(config));
        AlterConfigsResult alterConfigsResult = adminClient.incrementalAlterConfigs(configMaps);
    }

    /**
     * 增加partitions
     *
     * @param partitions
     */
    public static void incrPartitions(int partitions) {
        AdminClient adminClient = adminClient();
        Map<String, NewPartitions> partitionsMap = new HashMap<>();
        NewPartitions newPartitions = NewPartitions.increaseTo(partitions);
        partitionsMap.put(TOPIC_NAME, newPartitions);
        adminClient.createPartitions(partitionsMap);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AdminSample.incrPartitions(3);
        AdminSample.describeTopic();
    }
}
