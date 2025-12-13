package com.hotel.booking.airbnb.advices;

import com.hotel.booking.airbnb.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> resourceNotFound(MethodArgumentNotValidException noSuchElementException){

        Map<String, String> errors = new HashMap<>();

        for (FieldError error : noSuchElementException.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }



        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,errors.toString()
        );

        ApiResponse<?> response = new ApiResponse<>(apiError);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponse(ApiError error) {
        return new ResponseEntity<>(new ApiResponse<>(error),error.getStatus());
    }
}
