package com.heshi.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by fukun
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
