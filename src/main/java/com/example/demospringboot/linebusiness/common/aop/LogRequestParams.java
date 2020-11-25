package com.example.demospringboot.linebusiness.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogRequestParams {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void log(){}

    @Around("log()")
    public Object logRequestParams(ProceedingJoinPoint pjp) throws Throwable {
        log.info("aop====执行...");
        return pjp.proceed();
    }

}
