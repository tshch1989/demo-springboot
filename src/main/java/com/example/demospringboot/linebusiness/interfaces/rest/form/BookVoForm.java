package com.example.demospringboot.linebusiness.interfaces.rest.form;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import lombok.Data;
import lombok.NonNull;

import javax.annotation.Nonnull;

@Data
public class BookVoForm {
    private Long bookId;
    private String bookName;
    private String bookAuthor;

    @Nonnull
    public static BookVoForm fromBook(@NonNull Book book) {
        BookVoForm bookVoForm = new BookVoForm();
        bookVoForm.bookAuthor = book.getBookAuthor();
        bookVoForm.bookName = book.getBookName();
        bookVoForm.bookId  = book.getBookId();
        return bookVoForm;
    }
}
