package com.heshi.transaction;

import com.heshi.transaction.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/baseControler")
public class AccountController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/1")
    public void transfer() {
        try {
            accountsService.transfer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
