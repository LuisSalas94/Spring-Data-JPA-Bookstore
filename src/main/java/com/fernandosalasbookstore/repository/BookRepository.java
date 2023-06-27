package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Optional<Book> findById(Long id);
    List<Book> findByAuthorOrGenre(String author, String genre);
    List<Book> findByAuthorAndGenre(String author, String genre);
    List<Book> findByGenre(String genre);
    List<Book> findByPriceGreaterThan(BigDecimal price);
    List<Book> findByPriceLessThan(BigDecimal price);
    List<Book> findByAuthorContaining(String title);
}
