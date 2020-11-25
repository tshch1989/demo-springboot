package com.example.demospringboot.linebusiness.app.biz;

import com.example.demospringboot.common.exceptions.BizException;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookDetailVoForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookVoForm;
import lombok.NonNull;

import java.util.List;

public interface BookService {

    void addBook(@NonNull BookForm bookForm);

    @org.springframework.lang.NonNull
    List<BookVoForm> listBook();

    @org.springframework.lang.NonNull
    BookDetailVoForm bookDetail(long bookId) throws BizException;

    @org.springframework.lang.NonNull
    List<BookVoForm> searchByBookName(@NonNull String bookName);
}
