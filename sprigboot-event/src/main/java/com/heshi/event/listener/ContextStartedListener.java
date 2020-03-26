package com.heshi.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {
    Logger logger = LoggerFactory.getLogger(ContextStartedListener.class);

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedListener 服务启动中");
    }
}
