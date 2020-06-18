package com.heshi.kafka.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author: fukun
 * @Date: 2020/6/17
 */
@SpringBootApplication(scanBasePackages = "com.heshi.kafka.wechat")
public class WechatApp {

    public static void main(String[] args) {
        SpringApplication.run(WechatApp.class, args);
    }
}
