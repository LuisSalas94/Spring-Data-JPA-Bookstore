package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import com.fernandosalasbookstore.entity.BookCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookCategoryRepositoryTest {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Test
    void saveBookCategory() {
        BookCategory bookCategory = new BookCategory();

        bookCategory.setCategoryName("books");
        bookCategory.setCategoryDescription("books description");

        Book book1 = new Book();
        book1.setTitle("Core Java");
        book1.setAuthor("Cay S. Horstmann");
        book1.setDescription("Book1 description");
        book1.setPrice(new BigDecimal("10000"));
        book1.setGenre("Java");
        book1.setIsbn("ABCD");
        book1.setBookCategory(bookCategory);
        bookCategory.getBookList().add(book1);

        Book book2 = new Book();
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setDescription("Book2 description");
        book2.setPrice(new BigDecimal("20000"));
        book2.setGenre("Java");
        book2.setIsbn("EFGH");
        book2.setBookCategory(bookCategory);
        bookCategory.getBookList().add(book2);

        bookCategoryRepository.save(bookCategory);

        bookCategory.getBookList().forEach(book -> {
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book Author: " + book.getAuthor());
            System.out.println("*******************************");
        });

    }

}