package com.example.demospringboot.linebusiness.app.biz.impl;

import com.example.demospringboot.linebusiness.app.biz.BookService;
import com.example.demospringboot.common.exceptions.BizException;
import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.BookRepository;
import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import com.example.demospringboot.linebusiness.infrastructure.repositories.mongo.BookCatalogRepository;
import com.example.demospringboot.linebusiness.infrastructure.repositories.mongo.entity.BookCatalog;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookDetailVoForm;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookForm;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookVoForm;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookCatalogRepository bookCatalogRepository;
    private final RedisTemplate<String,String> redisTemplate;

    public BookServiceImpl(BookRepository bookRepository, BookCatalogRepository bookCatalogRepository, RedisTemplate redisTemplate) {
        this.bookRepository = bookRepository;
        this.bookCatalogRepository = bookCatalogRepository;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addBook(@NonNull BookForm bookForm) {
        Book book = new Book();
        book.setBookAuthor(bookForm.getBookAuthor());
        book.setBookName(bookForm.getBookName());
        bookRepository.saveAndFlush(book);

        BookCatalog bookCatalog = new BookCatalog();
        bookCatalog.setBookId(book.getBookId());
        bookCatalog.setBookCatalog(bookForm.getBookCatalog());
        bookCatalogRepository.insert(bookCatalog);
    }

    @Override
    public List<BookVoForm> listBook() {
        List<BookVoForm> bookVoForms = bookRepository.findAll().stream().map(BookVoForm::fromBook).collect(Collectors.toList());
        redisTemplate.opsForValue().set("test-key", bookVoForms.toString());
        String testValue = redisTemplate.opsForValue().get("test-key");
        log.info("redis访问正常: {}", testValue);
        return bookVoForms;
    }

    @Override
    public BookDetailVoForm bookDetail(@NonNull Long bookId) throws BizException {
        return bookRepository.findById(bookId).map(book -> {
            BookCatalog bookCatalog = bookCatalogRepository.findById(bookId).orElseGet(BookCatalog::new);
            return BookDetailVoForm.fromBookAndCatalog(book, bookCatalog);
        }).orElseThrow(BizException::new);
    }

    @Override
    public List<BookVoForm> searchByBookName(@NonNull String bookName) {
        return Optional.ofNullable(bookRepository.findLikeBookName(bookName))
                .map(books -> books.stream().map(BookVoForm::fromBook).collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }
}
