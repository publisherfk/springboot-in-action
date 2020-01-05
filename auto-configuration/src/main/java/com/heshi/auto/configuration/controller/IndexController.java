package com.heshi.auto.configuration.controller;

import com.heshi.auto.configuration.support.HystrixRequestAttributeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kun
 */
@RestController
@EnableConfigurationProperties(HystrixRequestAttributeProperties.class)
public class IndexController {

//    @Value("${hystrix.propagate.request-attribute.enabled}")
//    private Boolean hystrixCustomEnable;

    @Autowired
    private HystrixRequestAttributeProperties hystrixRequestAttributeProperties;

    @RequestMapping("")
    public Boolean index() {
        return hystrixRequestAttributeProperties.getEnabled();
    }
}
