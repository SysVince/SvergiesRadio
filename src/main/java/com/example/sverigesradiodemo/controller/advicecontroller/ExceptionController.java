package com.example.sverigesradiodemo.controller.advicecontroller;

import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String handleHttpRequestException(Model model){
        model.addAttribute("errmessage","Hoppsan! Sidan kan inte hittas. Det kan vara på grund av felaktig länk eller url");

    return "error";
    }


}
