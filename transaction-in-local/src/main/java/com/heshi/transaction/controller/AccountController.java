package com.heshi.transaction.controller;

import com.heshi.transaction.result.CodeMsg;
import com.heshi.transaction.result.Result;
import com.heshi.transaction.service.AccountsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base/controler")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/1")
    public Result transfer() {
        try {
            accountsService.transfer();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.error(CodeMsg.SERVER_ERROR);
        }
        return Result.success("成功");
    }
}
