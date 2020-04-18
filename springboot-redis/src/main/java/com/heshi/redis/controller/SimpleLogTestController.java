package com.heshi.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fukun
 * @Date: 2020/4/14 20:48
 * @since
 */
@RestController
@RequestMapping("/base/simple/log/test")
public class SimpleLogTestController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/test")
    public void test() {
        logger.info("======logger.info======");
        logger.debug("======debug.info======");
    }
}
