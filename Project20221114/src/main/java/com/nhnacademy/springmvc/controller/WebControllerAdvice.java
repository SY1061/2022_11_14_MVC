package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.StudentInvalidValueException;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(StudentInvalidValueException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleStudentInvalidValueException(StudentInvalidValueException ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex, Model model){
        model.addAttribute("exception", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleException(Exception ex, Model model) {
        log.error("", ex);

        model.addAttribute("exception", ex);
        return "error";
    }

}
