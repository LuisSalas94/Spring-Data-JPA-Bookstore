package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class QueryMethodTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByTitleMethod() {
        Book book = bookRepository.findByTitle("Cosmos");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
    @Test
    void findByIdMethod() {
        Book book = bookRepository.findById(6L).get();
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
    @Test
    void findByAuthorOrGenreMethod() {
     List<Book> bookList = bookRepository.findByAuthorOrGenre("Carl Sagan", "Science");
     bookList.forEach(book -> {
         System.out.println("Author: " + book.getAuthor());
         System.out.println("Genre: " + book.getGenre());
         System.out.println("Title: " + book.getTitle());
         System.out.println("*******************************");
     });
    }
    @Test
    void findByAuthorAndGenreMethod() {
        List<Book> bookList = bookRepository.findByAuthorAndGenre("Yuval Noah Harari", "Social Philosophy");
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByGenreMethod() {
       List<Book> bookList = bookRepository.findByGenre("Social Philosophy");
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByPriceGreaterThan() {
        List<Book> bookList = bookRepository.findByPriceGreaterThan(new BigDecimal("17.00"));
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByPriceLessThan() {
        List<Book> bookList = bookRepository.findByPriceLessThan(new BigDecimal("16.00"));
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByAuthorContainingMethod() {
        List<Book> bookList = bookRepository.findByAuthorContaining("Yuval");
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByPriceBetweenMethod() {
        List<Book> bookList = bookRepository.findByPriceBetween(new BigDecimal("14.00"), new BigDecimal("19.00"));
        bookList.forEach(book -> {
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("*******************************");
        });
    }



}
