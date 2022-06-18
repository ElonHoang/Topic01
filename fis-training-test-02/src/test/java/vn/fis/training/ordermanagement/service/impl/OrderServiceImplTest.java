package vn.fis.training.ordermanagement.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.fis.training.ordermanagement.domain.Customer;
import vn.fis.training.ordermanagement.domain.OrderStatus;
import vn.fis.training.ordermanagement.service.CustomerService;
import vn.fis.training.ordermanagement.service.OrderService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService o;

    @Autowired
    CustomerService c;
    @Test
    void findOrdersByOrderStatus() {
       OrderStatus od = OrderStatus.APPROVED;
        o.findOrdersByOrderStatus(od);
        //assertEquals(od,o.findOrdersByOrderStatus(od));
    }

    @Test
    void findOrdersByCustomer() {
        Customer ct = c.findAll().stream().filter(t->t.getId() == 1L).findFirst().get();
        o.findOrdersByCustomer(ct);
    }

    @Test
    void testDateTime(){
        String str = "2016-03-04 11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        o.findOrdersBetween(dateTime,LocalDateTime.now());
    }
}