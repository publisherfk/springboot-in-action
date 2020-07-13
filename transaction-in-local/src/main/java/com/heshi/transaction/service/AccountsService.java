package com.heshi.transaction.service;

import com.heshi.transaction.domain.Account;
import com.heshi.transaction.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AccountsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Transactional
    public void transfer() throws SQLException {
        String plus = "UPDATE " + Account.TABLE_NAME + " SET MONEY= MONEY+1000 where user_name=?";
        String minus = "UPDATE " + Account.TABLE_NAME + " SET MONEY= MONEY-1000 where user_name=?";
        update(plus, "heshi");
        int aa = 33 / 0;
        update(minus, "fukun");
    }

//    public void transfer() throws SQLException {
//        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
//        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        TransactionStatus transactionStatus = transactionManager.getTransaction(definition);
//        try {
//            String plus = "UPDATE " + Account.TABLE_NAME + " SET MONEY= MONEY+1000 where user_name=?";
//            String minus = "UPDATE " + Account.TABLE_NAME + " SET MONEY= MONEY-1000 where user_name=?";
//            update(plus, "heshi");
//            int aa = 33 / 0;
//            update(minus, "fukun");
//            transactionManager.commit(transactionStatus);
//        } catch (Exception e) {
//            transactionManager.rollback(transactionStatus);
//        }
//
//    }
    public int update(String sql, String userName) throws SQLException {
        return jdbcTemplate.update(sql, userName);
    }

    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }
}
