package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Optional<Book> findById(Long id);
}
