package com.example.demo;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"com.example.demo"})
class DemoApplicationTests {

    @Test
    void contextLoads() {
        Order order = new Order();
        order.setSource("mobile");
        order.setPayMethod("alipay");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoApplicationTests.class);
        ((OrderService)applicationContext.getBean("orderService")).orderService(order);
    }

}
