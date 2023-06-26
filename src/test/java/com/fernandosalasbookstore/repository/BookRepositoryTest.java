package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveMethod() {
        Book book = new Book();
        book.setTitle("Brief Answers to the Big Questions");
        book.setAuthor("Stephen Hawking");
        book.setDescription("The book examines some of the universe's greatest mysteries, and promotes the view that science is very important in helping to solve problems on planet Earth.");
        book.setPrice(new BigDecimal("14.25"));
        book.setGenre("Cosmology");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1b5");
        Book newBook = bookRepository.save(book);
        System.out.println(book.toString());
    }

    

}