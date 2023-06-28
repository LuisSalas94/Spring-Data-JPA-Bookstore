package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NativeSQLQueriesTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByAuthorOrTitleNativeSQLIndexParamMethod() {
        List<Book> bookList = bookRepository.findByAuthorOrTitleNativeSQLIndexParam("Carl Sagan", "Cosmos");
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }
    @Test
    void findByAuthorOrTitleNativeSQLNamedParamMethod() {
        List<Book> bookList = bookRepository.findByAuthorOrTitleNativeSQLNamedParam("Yuval Noah Harari", "Sapiens: A Brief History of Humankind");
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Description: " + book.getDescription());
            System.out.println("*******************************");
        });
    }
}
