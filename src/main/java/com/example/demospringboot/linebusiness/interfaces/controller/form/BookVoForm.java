package com.example.demospringboot.linebusiness.interfaces.controller.form;

import com.example.demospringboot.linebusiness.infrastructure.repositories.jpa.entity.Book;
import lombok.Data;
import lombok.NonNull;

@Data
public class BookVoForm {
    private Long bookId;
    private String bookName;
    private String bookAuthor;

    @org.springframework.lang.NonNull
    public static BookVoForm fromBook(@NonNull Book book) {
        BookVoForm bookVoForm = new BookVoForm();
        bookVoForm.bookAuthor = book.getBookAuthor();
        bookVoForm.bookName = book.getBookName();
        bookVoForm.bookId  = book.getBookId();
        return bookVoForm;
    }
}
