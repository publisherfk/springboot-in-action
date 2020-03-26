package com.heshi.server1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/oauth2/v1/checkAccount")
    public Map checkAccount(@RequestBody Map<String, String> param) {
        String userName = param.get("userName");
        String password = param.get("password");
        Map<String, Boolean> map = new HashMap<>();
        logger.info("userName:{}", userName);
        logger.info("password:{}", password);
        logger.info("password:{}", DigestUtils.md5DigestAsHex(password.getBytes()));
        map.put("result", true);
        return map;
    }

}
