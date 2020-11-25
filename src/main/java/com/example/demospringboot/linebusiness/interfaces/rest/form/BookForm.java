package com.example.demospringboot.linebusiness.interfaces.rest.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookForm {
    @NotEmpty
    private String bookName;
    @NotEmpty
    private String bookAuthor;
    @NotEmpty
    private String bookCatalog;
}
