package com.example.demospringboot.linebusiness.infrastructure.repositories.jpa;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByBookNameLike(String bookName);

}
