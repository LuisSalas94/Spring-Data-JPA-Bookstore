package com.fernandosalasbookstore.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String orderTrackingNumber;

    private int totalQuantity;

    private BigDecimal totalPrice;

    private String status;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    // Unidirectional One-to-One Mapping
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "billing_address_id", referencedColumnName = "id")

    // Bidirectional One-To-One Mapping
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Address billingAddress;

    // Unidirectional Mapping
    // Default fetch type for one to many is LAZY
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Set<OrderItem> orderItems = new HashSet<>();

    // Bidirectional One-To-Many Mapping
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public BigDecimal getTotalAmount() {
       BigDecimal amount = new BigDecimal("0.0");
       for(OrderItem item : this.orderItems) {
           amount = amount.add(item.getPrice());
       }
       return amount;
    }
}
