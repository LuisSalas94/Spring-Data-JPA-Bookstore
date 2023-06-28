package com.fernandosalasbookstore.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NamedQuery(
        name = "Book.findByAuthor",
        query = "select b from Book b where b.author = ?1"
)

@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String title;

    private String author;

    @Column(nullable = false, unique = true)
    private String description;

    private BigDecimal price;

    private String genre;

    @Column(nullable = false, unique = true)
    private String isbn;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
