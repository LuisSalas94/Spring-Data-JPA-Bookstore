package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Address;
import com.fernandosalasbookstore.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("In Progress");
        order.setTotalPrice(new BigDecimal(1000));

        Address address = new Address();
        address.setCity("Lima");
        address.setStreet("Universitaria");
        address.setCountry("Peru");
        address.setZipCode("411047");

        order.setBillingAddress(address);
        orderRepository.save(order);
    }

    @Test
    void getOrderMethod() {
        Order order = orderRepository.findById(2L).get();
        System.out.println(order.toString());
    }

    @Test
    void updateOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        order.setStatus("Delivered");
        order.getBillingAddress().setZipCode("411087");
        orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod() {
        orderRepository.deleteById(1L);
    }
}
