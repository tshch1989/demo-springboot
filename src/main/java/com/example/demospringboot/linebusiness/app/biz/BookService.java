package com.example.demospringboot.linebusiness.app.biz;

import com.example.demospringboot.linebusiness.common.exceptions.BizException;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookDetailVoForm;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookForm;
import com.example.demospringboot.linebusiness.interfaces.controller.form.BookVoForm;
import lombok.NonNull;

import java.util.List;

public interface BookService {

    void addBook(@NonNull BookForm bookForm);

    @org.springframework.lang.NonNull
    List<BookVoForm> listBook();

    @org.springframework.lang.NonNull
    BookDetailVoForm bookDetail(@NonNull Long bookId) throws BizException;

    @org.springframework.lang.NonNull
    List<BookVoForm> searchByBookName(@NonNull String bookName);
}
