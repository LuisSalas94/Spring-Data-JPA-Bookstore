package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    void sorting() {
        String sortBy = "price";
        //String sortDir = "desc";
        List<Book> bookList = bookRepository.findAll(Sort.by(sortBy).descending());
        bookList.forEach(book -> {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("***************************");
        });
    }

    @Test
    void sortingByMultipleFields() {
        String sortBy = "title";
        String sortByPrice = "price";
        String sortDir = "desc";

        Sort sortByTitle = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByBookPrice = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByPrice).ascending() : Sort.by(sortByPrice).descending();

        Sort groupBySort = sortByTitle.and(sortByBookPrice);

        List<Book> bookList = bookRepository.findAll(groupBySort);
        bookList.forEach(book -> {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Description: " + book.getDescription());
            System.out.println("***************************");
        });
    }
}
