package com.heshi.server1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/msgcenter")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        logger.info((String) request.getAttribute("jwtUser"));
        return "9523";
    }
}
