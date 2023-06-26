package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
