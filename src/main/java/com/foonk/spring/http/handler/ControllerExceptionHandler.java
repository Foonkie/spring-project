package com.foonk.spring.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice(basePackages = "com.foonk.spring.http.controller")
public class ControllerExceptionHandler /*extends ResponseEntityExceptionHandler*/ {
    @ExceptionHandler(Exception.class)
    public String handleExceptions(Exception exception, HttpServletRequest httpServletRequest){
        log.error("Failed to return response", exception);
        return "error/error500";
    }
}
