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
        book.setTitle("Brief Answers to the Big Questions");
        book.setAuthor("Stephen Hawking");
        book.setDescription("The book examines some of the universe's greatest mysteries, and promotes the view that science is very important in helping to solve problems on planet Earth.");
        book.setPrice(new BigDecimal("14.25"));
        book.setGenre("Cosmology");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1b5");
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
        book.setTitle("Cosmos");
        book.setAuthor("Carl Sagan");
        book.setDescription("Cosmos is one of the bestselling science books of all time. In clear-eyed prose, Sagan reveals a jewel-like blue world inhabited by a life form that is just beginning to discover its own identity and to venture into the vast ocean of space. ");
        book.setPrice(new BigDecimal("14.79"));
        book.setGenre("Science");
        book.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1a1");

        Book book2 = new Book();
        book2.setTitle("Sapiens: A Brief History of Humankind");
        book2.setAuthor("Yuval Noah Harari");
        book2.setDescription("rom a renowned historian comes a groundbreaking narrative of humanity’s creation and evolution—a #1 international bestseller—that explores the ways in which biology and history have defined us and enhanced our understanding of what it means to be human.");
        book2.setPrice(new BigDecimal("19.89"));
        book2.setGenre("History");
        book2.setIsbn("b1a199b6-428f-4e5b-8fc3-fd6b99e1b1a4");

        List<Book> bookList = bookRepository.saveAll(List.of(book, book2));
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

    


}