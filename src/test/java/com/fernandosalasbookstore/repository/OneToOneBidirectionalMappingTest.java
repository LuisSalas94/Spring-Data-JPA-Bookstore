package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Address;
import com.fernandosalasbookstore.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveAddressMethod() {
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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod() {
        Address address = addressRepository.findById(1L).get();
        address.setZipCode("411048");
        address.getOrder().setStatus("Delivered");
        addressRepository.save(address);
    }

    @Test
    void fetchAddressMethod() {
        Address address = addressRepository.findById(1L).get();
    }

    @Test
    void deleteAddressMethod() {
        addressRepository.deleteById(2L);
    }

}
