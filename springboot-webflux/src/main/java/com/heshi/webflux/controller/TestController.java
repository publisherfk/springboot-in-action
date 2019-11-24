package com.heshi.webflux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/")
    String index() {
        logger.info("开始执行==index");
        String result = createStr();
        logger.info("执行结束==index");
        return result;
    }

    @GetMapping("/webflux")
    Mono<String> webflux() {
        logger.info("开始执行==webflux");
        Mono<String> result = Mono.fromSupplier(() -> createStr());
        logger.info("执行结束==webflux");
        return result;
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<String> flux() {
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            return "retutn" + i;
        }));
        return result;
    }

    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return "任务完成";
    }
}
