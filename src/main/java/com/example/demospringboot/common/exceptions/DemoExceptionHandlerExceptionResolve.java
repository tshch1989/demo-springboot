package com.example.demospringboot.common.exceptions;

import com.example.demospringboot.common.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandlerExceptionResolve {

    public DemoExceptionHandlerExceptionResolve(){
        log.info("DemoExceptionHandlerExceptionResolve==初始化...");
    }

    @ExceptionHandler({ValidationException.class, BindException.class})
    public Object handle(Exception ex, HttpServletRequest request){
        if(RequestUtil.isAjax(request)){
            return ResponseEntity.ok("fail: params error.");
        }else {
            return new ModelAndView("/error/4xx");
        }
    }
}
