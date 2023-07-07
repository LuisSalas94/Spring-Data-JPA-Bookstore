package com.fernandosalasbookstore.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageUrl;

    private BigDecimal price;

    private int quantity;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
