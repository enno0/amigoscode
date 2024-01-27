package com.amogoscode.enno.GlobalExceptionHandler;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@Service
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e, Model model, HttpServletRequest request) {
        System.out.println(request.getRequestURI() + ": " + e);
        String mm = e.getMessage();
        System.out.println(mm);

        model.addAttribute("error", e.getMessage());
        return "error";
    }
}
