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
}
