package com.heshi.spring.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: fukun
 * @Date: 2020/4/9 21:26
 * @since
 */
@RestController
@RequestMapping("/base/spring/session")
public class SessionTestController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/put")
    public void set(String key, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    @GetMapping("/get")
    public Object get(String key) {
        HttpSession session = request.getSession();
        return session.getAttribute(key);
    }
}
