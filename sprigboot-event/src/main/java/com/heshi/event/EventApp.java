package com.heshi.event;

import com.heshi.event.listener.ApplicationPreparedEventListener;
import com.heshi.event.listener.ApplicationStartingEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(EventApp.class);
        springApplication.addListeners(new ApplicationStartingEventListener());
        springApplication.addListeners(new ApplicationPreparedEventListener());
        springApplication.run(args);
    }
}
