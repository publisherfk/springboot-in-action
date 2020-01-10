package com.heshi.h2db.service;

import com.heshi.h2db.dao.CustomerRepository;
import com.heshi.h2db.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;

@Service
public class CustomerServiceInCode {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    public Customer create(Customer customer) {
        if (null != customer.getId()) {
            throw new RuntimeException("用户已经存在");
        }
//        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
//        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
//        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//        defaultTransactionDefinition.setTimeout(15);
//        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            customer.setUserName("Code:" + customer.getUserName());
            customerRepository.save(customer);
//            transactionManager.commit(status);
            return customer;
        } catch (TransactionException e) {
//            transactionManager.rollback(status);
            throw e;
        }
    }
}
