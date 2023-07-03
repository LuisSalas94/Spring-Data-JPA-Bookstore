package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void Pagination() {
        int pageNo = 0;
        int pageSize = 5;
        // create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        // findAll method and pass pageable instance
        Page<Book> page = bookRepository.findAll(pageable);

        List<Book> bookList = page.getContent();
        bookList.forEach(book -> {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("*******************************");
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();
        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();

        System.out.println("Total page: " + totalPage);
        System.out.println("Total Elements: " + totalElements);
        System.out.println("Number of Elements: " + numberOfElements);
        System.out.println("Size: " + size);
        System.out.println("Is last?: " + isLast);
        System.out.println("Is first: " + isFirst);
    }
}
