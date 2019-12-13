package com.heshi.greendill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by fukun
 */
@RestController
@RequestMapping("/base")
public class BaseController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
