package com.alkemy.challenge.challenge.controller;

import com.alkemy.challenge.challenge.dto.ApiErrorDTO;
import com.alkemy.challenge.challenge.exception.ParamNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={ParamNotFound.class})
    protected ResponseEntity<Object>handleParamNotFound(RuntimeException ex, WebRequest request){
        ApiErrorDTO errorDTO=new ApiErrorDTO(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                Arrays.asList("param not found")
        );
        return handleExceptionInternal(ex,errorDTO,new HttpHeaders(),HttpStatus.NOT_FOUND,request);
    }
}
