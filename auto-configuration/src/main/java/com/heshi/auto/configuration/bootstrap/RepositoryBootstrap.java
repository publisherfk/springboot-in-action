package com.heshi.auto.configuration.bootstrap;

import com.heshi.auto.configuration.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author kun
 */
@ComponentScan(basePackages = "com.heshi.auto.configuration.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class).web(WebApplicationType.NONE).run(args);
        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        System.out.println(myFirstLevelRepository.toString());
        context.close();
    }
}
