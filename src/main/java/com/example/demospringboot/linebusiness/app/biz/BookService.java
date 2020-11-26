package com.example.demospringboot.linebusiness.app.biz;

import com.example.demospringboot.common.exceptions.BizException;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookDetailVoForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookVoForm;
import lombok.NonNull;

import javax.annotation.Nonnull;
import java.util.List;

public interface BookService {

    void addBook(@NonNull BookForm bookForm);

    @Nonnull
    List<BookVoForm> listBook();

    @Nonnull
    BookDetailVoForm bookDetail(long bookId) throws BizException;

    @Nonnull
    List<BookVoForm> searchByBookName(@NonNull String bookName);

    void clearBook();
}
