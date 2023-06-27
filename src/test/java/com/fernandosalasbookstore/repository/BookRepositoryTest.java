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
        book.setTitle("The Demon-Haunted World: Science as a Candle in the Dark");
        book.setAuthor("Carl Sagan");
        book.setDescription("Casting a wide net through history and culture, Sagan examines and authoritatively debunks such celebrated fallacies of the past as witchcraft, faith healing, demons, and UFOs.");
        book.setPrice(new BigDecimal("18.79"));
        book.setGenre("Science");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1a2\"");

        Book book2 = new Book();
        book2.setTitle("The Dragons of Eden: Speculations on the Evolution of Human Intelligence");
        book2.setAuthor("Carl Sagan");
        book2.setDescription("Dr. Carl Sagan takes us on a great reading adventure.");
        book2.setPrice(new BigDecimal("15.69"));
        book2.setGenre("Science");
        book2.setIsbn("1a199b6-428f-4e5b-8fc3-fd6b99e1b1a3");

        Book book3 = new Book();
        book3.setTitle("Homo Deus: A Brief History of Tomorrow");
        book3.setAuthor("Yuval Noah Harari");
        book3.setDescription("Over the past century, humankind has managed to do the impossible.");
        book3.setPrice(new BigDecimal("22.69"));
        book3.setGenre("Social Philosophy");
        book3.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1a5");


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