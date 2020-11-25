package com.example.demospringboot.linebusiness.interfaces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewController {

    @GetMapping("")
    public String index(){
        return "book-manage";
    }

}
