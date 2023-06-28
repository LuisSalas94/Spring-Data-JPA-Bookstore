package com.fernandosalasbookstore.repository;

import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByAuthor() {
        List<Book> bookList = bookRepository.findByAuthor("Carl Sagan");
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }
    @Test
    void findAllOrderByAuthorDesc() {
        List<Book> bookList = bookRepository.findAllOrderByAuthorDesc();
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByPriceBetweenJPQLMethod() {
        List<Book> bookList = bookRepository.findByPriceBetweenJPQL(new BigDecimal("14"), new BigDecimal("17"));
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("*******************************");
        });
    }

}
