package com.fernandosalasbookstore.repository;
import com.fernandosalasbookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // Define JPQL query named parameters
    @Query("select b from Book b where b.author =:author or b.title =:title")
    List<Book> findByAuthorOrTitleJPQLNamedParam(@Param("author") String author,
                                                 @Param("title") String title);

    // Define Native SQL query using @Query annotation with index or position parameters
    @Query(value = "select * from books b where b.author = ?1 or b.title = ?2", nativeQuery = true)
    List<Book> findByAuthorOrTitleNativeSQLIndexParam(String author, String title);

    // Define Native SQL query using @Query annotation with named parameters
    @Query(value = "select * from books b where b.author = :author or b.title = :title", nativeQuery = true)
    List<Book> findByAuthorOrTitleNativeSQLNamedParam(@Param("author") String author,
                                                      @Param("title") String title);
}
