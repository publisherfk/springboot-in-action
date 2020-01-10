package com.heshi.h2db.controller;

import com.heshi.h2db.dao.CustomerRepository;
import com.heshi.h2db.domain.Customer;
import com.heshi.h2db.service.CustomerServiceInAnnotation;
import com.heshi.h2db.service.CustomerServiceInCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
public class CustomerController {
    @Autowired
    private CustomerServiceInAnnotation customerServiceInAnnotation;
    @Autowired
    private CustomerServiceInCode customerServiceInCode;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/annotation")
    public Customer createInAnnotation(@RequestBody Customer customer) {
        return customerServiceInAnnotation.create(customer);
    }

    @PostMapping("/create")
    public Customer createInCode(@RequestBody Customer customer) {
        return customerServiceInCode.create(customer);
    }

    @PostMapping("/findAll")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
