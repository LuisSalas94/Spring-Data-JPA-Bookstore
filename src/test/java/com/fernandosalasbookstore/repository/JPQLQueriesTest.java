package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JPQLQueriesTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByAuthorOrTitleJPQLParamMethod() {
        List<Book> bookList = bookRepository.findByAuthorOrTitleJPQLIndexParam("Carl Sagan", "Cosmos");
        bookList.forEach(book->{
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Title: " + book.getTitle());
            System.out.println("*******************************");
        });
    }

}
