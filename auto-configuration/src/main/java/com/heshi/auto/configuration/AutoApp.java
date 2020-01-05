package com.heshi.auto.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author kun
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.heshi.auto.configuration.web.servlet")
public class AutoApp {
    public static void main(String[] args) {
        SpringApplication.run(AutoApp.class);
    }
}
