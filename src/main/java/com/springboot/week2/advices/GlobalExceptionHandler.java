package com.springboot.week2.advices;

import com.springboot.week2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException){
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(resourceNotFoundException.getMessage()).build();

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleInternalServerError(Exception exception){
        ApiError error = ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(exception.getMessage()).build();

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentException(MethodArgumentNotValidException argumentNotValidException){
        List<String> exceptions = argumentNotValidException.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        ApiError error = ApiError.builder().status(HttpStatus.BAD_REQUEST).message(exceptions.toString()).build();

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
