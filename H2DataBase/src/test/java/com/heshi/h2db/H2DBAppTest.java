package com.heshi.h2db;

import com.heshi.h2db.controller.CustomerController;
import com.heshi.h2db.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class H2DBAppTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void getHello() {
        Customer customer = new Customer();
//        customer.setId((long) ((Math.random() * 100) + 1));
        customer.setUserName("hedi");
        customer.setPassword("k");
        customer.setRole("r");
        customerController.createInCode(customer);
        List<Customer> customers = customerController.findAll();
        customers.stream().forEach(customer1 -> System.out.println(customer1.toString()));
    }
}