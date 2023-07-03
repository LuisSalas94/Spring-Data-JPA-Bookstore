package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveMethod() {
        Book book = new Book();
        book.setTitle("21 Lessons for the 21st Century");
        book.setAuthor("Yuval Noah Harari");
        book.setDescription("Yuval Noah Harari’s 21 Lessons for the 21st Century is a probing and visionary investigation into today’s most urgent issues.");
        book.setPrice(new BigDecimal("18.59"));
        book.setGenre("Social Philosophy");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1a6");
        Book newBook = bookRepository.save(book);
        System.out.println(book.toString());
    }

    @Test
    void updateMethod() {
        Book book = bookRepository.findById(1L).get();
        book.setPrice(new BigDecimal("15.25"));
        book.setDescription("Brief Answers to the Big Questions is a popular science book written by physicist Stephen Hawking, and published by Hodder & Stoughton (hardcover) and Bantam Books (paperback)");
        Book newBook = bookRepository.save(book);
        System.out.println("Price: " + newBook.getPrice());
        System.out.println("Description: " + newBook.getDescription());
    }

    @Test
    void findByIdMethod() {
        Book book = bookRepository.findById(1L).get();
        System.out.println("Title: " + book.getTitle());
        System.out.println("Description: " + book.getDescription());
        System.out.println("Id: " + book.getId());
    }

    @Test
    void saveAllMethod() {
        Book book = new Book();
        book.setTitle("12 Rules for Life: An Antidote to Chaos");
        book.setAuthor("Jordan B. Peterson");
        book.setDescription("The number one Sunday Times and Audible best seller from 'the most influential public intellectual in the Western world.");
        book.setPrice(new BigDecimal("15.69"));
        book.setGenre("Self Help");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1c1");

        Book book2 = new Book();
        book2.setTitle("Beyond Order: 12 More Rules for Life");
        book2.setAuthor("Jordan B. Peterson\"");
        book2.setDescription("Jordan B. Peterson's Maps of Meaning is now available for the first time.");
        book2.setPrice(new BigDecimal("17.69"));
        book2.setGenre("Self Help");
        book2.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1c2");

        Book book3 = new Book();
        book3.setTitle("Maps of Meaning");
        book3.setAuthor("Jordan B. Peterson");
        book3.setDescription("Jordan B. Peterson's Maps of Meaning is now available for the first time from 'the most influential public intellectual in the Western world.");
        book3.setPrice(new BigDecimal("22.69"));
        book3.setGenre("Self Help");
        book3.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1c3");


        List<Book> bookList = bookRepository.saveAll(List.of(book, book2, book3));
        bookList.forEach(item-> {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor());
            System.out.println("Description: " + item.getDescription());
            System.out.println("*****************************************");
        });
    }

    @Test
    void findAllMethod(){
       List<Book> bookList = bookRepository.findAll();
        bookList.forEach(item-> {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor());
            System.out.println("Description: " + item.getDescription());
            System.out.println("*****************************************");
        });
    }

    @Test
    void deleteByIdMethod() {
        bookRepository.deleteById(1L);
    }

    @Test
    void deleteMethod() {
        Book book = bookRepository.findById(2L).get();
        bookRepository.delete(book);
    }

    @Test
    void deleteAllMethod() {
        bookRepository.deleteAll();
    }

    @Test
    void countMethod() {
        long bookCount = bookRepository.count();
        System.out.println("Number of Books: " + bookCount);
    }

    @Test
    void existsByIdMethod() {
       boolean result = bookRepository.existsById(5L);
       System.out.println("Does book with id 5 exist: " + result);
    }


}