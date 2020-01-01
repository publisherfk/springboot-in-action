package com.heshi.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author by fukun
 */
@SpringBootApplication
@ComponentScan("com.heshi.greendill")
public class ConfigApp {
    public static void main(String args[]) {
        SpringApplication.run(ConfigApp.class, args);
    }
}
