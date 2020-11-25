package com.example.demospringboot.linebusiness.infrastructure.repositories.jpa;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.bookName like :bookName%")
    List<Book> findLikeBookName(@Param("bookName") String bookName);
}
