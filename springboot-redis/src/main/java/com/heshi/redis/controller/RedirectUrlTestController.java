package com.heshi.redis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: fukun
 * @Date: 2020/4/18 19:26
 * @since
 */
@Controller
@RequestMapping("/base/redis")
public class RedirectUrlTestController {
    @GetMapping("/redirect")
    public Object urlRedirect() {
        return "redirect:/base/redis/result";
    }

    @GetMapping("/result")
    @ResponseBody
    public String returnValue() {
        return "重定向的值";
    }
}
