package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.service.CustomerService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService c;
    @Test
    void createCustomer() {
        Customer cs = new Customer(2L,"Hoang","001","HN");
        c.createCustomer(cs);
    }

    @Test
    void updateCustomer() {
        Customer cs = new Customer();
        cs.setId(1L);
        cs.setAddress("Hoanggg");
        cs.setName("Hoang");
        cs.setMobile("0000111");
        c.updateCustomer(cs);
    }

    @Test
    void deleteCustomerById() {
        c.deleteCustomerById(2L);
    }

    @Test
    void findAll() {
        c.findAll();
    }

    @Test
    void findByMobileNumber() {
        c.findByMobileNumber("001");
    }
}