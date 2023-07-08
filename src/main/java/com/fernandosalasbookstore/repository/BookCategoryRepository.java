package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
