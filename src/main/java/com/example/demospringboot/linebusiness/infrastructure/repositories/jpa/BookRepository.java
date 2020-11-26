package com.example.demospringboot.linebusiness.infrastructure.repositories.jpa;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("from Book where bookName like %:bookName%")
    List<Book> findByBookNameLike(@Param("bookName") String bookName);

}
