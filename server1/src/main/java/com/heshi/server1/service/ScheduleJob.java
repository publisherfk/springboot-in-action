package com.heshi.server1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleJob {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "10/1 * * * * ?")
    public void autoCloseOrder() {
        logger.info("======正在执行调度任务========");
    }
}