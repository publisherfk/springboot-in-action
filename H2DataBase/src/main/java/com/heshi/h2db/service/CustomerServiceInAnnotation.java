package com.heshi.h2db.service;

import com.heshi.h2db.dao.CustomerRepository;
import com.heshi.h2db.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceInAnnotation {

    Logger logger = LoggerFactory.getLogger(CustomerServiceInAnnotation.class);
    @Autowired
    private CustomerRepository customerRepository;

    //    @Transactional
    public Customer create(Customer customer) {
        if (null != customer.getId()) {
            throw new RuntimeException("用户已经存在");
        }
        customer.setUserName("Annotation:" + customer.getUserName());
        return customerRepository.save(customer);
    }
}
