package com.example.demospringboot.linebusiness.interfaces.controller;

import com.example.demospringboot.common.exceptions.BizException;
import com.example.demospringboot.linebusiness.app.biz.BookService;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookDetailVoForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookForm;
import com.example.demospringboot.linebusiness.interfaces.rest.form.BookVoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@Validated
public class BooKController {

    private final BookService bookService;

    public BooKController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book/add")
    public String addBook(BookForm bookForm){
        bookService.addBook(bookForm);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String listBook(Model model){
        List<BookVoForm> bookVoForms = bookService.listBook();
        model.addAttribute("books", bookVoForms);
        return "book-list";
    }

    @GetMapping("/book/detail")
    public String bookDetail(@NotNull @Min(1) Long bookId, Model model) throws BizException {
        BookDetailVoForm bookDetailVoForm = bookService.bookDetail(bookId);
        model.addAttribute("book", bookDetailVoForm);
        return "book-detail";
    }

    @PostMapping("/book/search.json")
    @ResponseBody
    public List<BookVoForm> bookSearch(@NotEmpty String bookName){
        return bookService.searchByBookName(bookName);
    }
}
