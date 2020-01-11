package com.heshi.redis.config;

import com.heshi.redis.common.RedisChannelEnums;
import com.heshi.redis.sub.BaseSub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class RedisConfig {
    private ConcurrentHashMap<String, BaseSub> classInstanceMap = new ConcurrentHashMap<>(20);

    public RedisConfig(HashMap<String, BaseSub> strategyMap) {
        this.classInstanceMap.clear();
        strategyMap.forEach((k, v) -> this.classInstanceMap.put(k.toLowerCase(), v));
    }

    /**
     * redis消息监听器容器
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        RedisChannelEnums[] redisChannelEnums = RedisChannelEnums.values();
        if (redisChannelEnums.length > 0) {
            Arrays.stream(redisChannelEnums)
                    .filter(redisChannelEnum -> redisChannelEnum != null && !StringUtils.isEmpty(redisChannelEnum.getCode()) && redisChannelEnum.getClassName() != null)
                    .forEach(redisChannelEnum -> {
                        String lowerCaseClassName = redisChannelEnum.getClassName().getSimpleName().toLowerCase();
                        BaseSub baseSub = classInstanceMap.get(lowerCaseClassName);
                        container.addMessageListener(listenerAdapter(baseSub), new PatternTopic(redisChannelEnum.getCode()));
                    });
        }
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(BaseSub baseSub) {
        return new MessageListenerAdapter(baseSub, "receiveMessage");
    }
}
