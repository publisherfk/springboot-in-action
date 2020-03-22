package com.heshi.redis.controller;

import com.heshi.redis.service.RedisChannelTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base/redis/channel")
public class RedisChannelTestController {
    @Autowired
    private RedisChannelTestService channelTestService;

    @GetMapping("/sendMessage")
    public void sendMessage(String channel, String message) {
        channelTestService.send(channel, message);
    }
}
