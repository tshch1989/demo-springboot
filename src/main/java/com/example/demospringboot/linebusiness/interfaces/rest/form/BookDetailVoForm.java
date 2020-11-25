package com.example.demospringboot.linebusiness.interfaces.rest.form;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import com.example.demospringboot.linebusiness.infrastructure.repositories.mongo.entity.BookCatalog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookDetailVoForm extends BookVoForm{
    private String bookCatalog;

    public static BookDetailVoForm fromBookAndCatalog(@NonNull Book book,@NonNull BookCatalog bookCatalog) {
        BookDetailVoForm form = new BookDetailVoForm();
        form.setBookCatalog(bookCatalog.getBookCatalog());
        form.setBookAuthor(book.getBookAuthor());
        form.setBookId(book.getBookId());
        form.setBookName(book.getBookName());
        return form;
    }
}
