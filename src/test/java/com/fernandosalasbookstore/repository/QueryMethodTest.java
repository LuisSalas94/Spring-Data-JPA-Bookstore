package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
