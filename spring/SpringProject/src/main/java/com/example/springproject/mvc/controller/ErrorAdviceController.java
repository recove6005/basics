package com.example.springproject.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorAdviceController {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView no_handler(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "NO HANDLER!!");
        modelAndView.setViewName("/error/default");
        return modelAndView;
    }


    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ModelAndView exception_handler(ArrayIndexOutOfBoundsException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "제대로 해라 ^-^..." + e.getMessage());
        modelAndView.setViewName("/error/default");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public String exception_handler(Exception e){
        return "/error/default";
    }
}