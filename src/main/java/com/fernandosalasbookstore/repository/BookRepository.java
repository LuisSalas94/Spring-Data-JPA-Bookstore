package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Optional<Book> findById(Long id);
    List<Book> findByAuthorOrGenre(String author, String genre);
    List<Book> findByAuthorAndGenre(String author, String genre);
    List<Book> findByGenre(String genre);
    List<Book> findByPriceGreaterThan(BigDecimal price);
    List<Book> findByPriceLessThan(BigDecimal price);
    List<Book> findByAuthorContaining(String title);
    List<Book> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);
    List<Book> findFirst2OrderByAuthor(String author);
    List<Book> findFirst3ByOrderByPriceAsc();

    // Define JPQL query using @Query annotation with index or position parameters
    @Query("select b from Book b where b.author = ?1 or b.title = ?2")
    List<Book> findByAuthorOrTitleJPQLIndexParam(String author, String title);

}
