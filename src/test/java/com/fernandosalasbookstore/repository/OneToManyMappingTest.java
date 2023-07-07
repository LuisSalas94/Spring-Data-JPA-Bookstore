package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Address;
import com.fernandosalasbookstore.entity.Order;
import com.fernandosalasbookstore.entity.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    //save order along with also save its order items
    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("In Progress");

        // create order item1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setBook(bookRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getBook().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.pgn");
        order.getOrderItems().add(orderItem1);

        // create order item2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setBook(bookRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem1.getBook().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.pgn");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Lima");
        address.setStreet("Universitaria");
        address.setState("Lima");
        address.setCountry("Peru");
        address.setZipCode("411047");

        order.setBillingAddress(address);

        orderRepository.save(order);

    }
}
