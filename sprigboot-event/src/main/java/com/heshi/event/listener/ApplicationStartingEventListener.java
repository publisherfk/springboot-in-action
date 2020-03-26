package com.heshi.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
    Logger logger = LoggerFactory.getLogger(ApplicationStartingEvent.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("starting 监听");
    }
}
