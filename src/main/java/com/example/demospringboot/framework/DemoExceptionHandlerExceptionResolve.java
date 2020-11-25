package com.example.demospringboot.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandlerExceptionResolve {

    public DemoExceptionHandlerExceptionResolve(){
        log.info("初始化...");
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<String> handle(ValidationException ex){
        return ResponseEntity.ok("fail: params error.");
    }
}
