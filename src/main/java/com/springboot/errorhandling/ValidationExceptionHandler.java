package com.springboot.errorhandling;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        // Extract the error message from the exception
        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        // Create a ResponseEntity with a 400 Bad Request status and the error message
        return ResponseEntity.badRequest().body(errorMessage);
    }
    
    @ExceptionHandler(ResourceCreationException.class)
    public ResponseEntity<Map<String, Object>> handleResourceCreationException(ResourceCreationException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", Map.of(
            "code", ex.getCode(),
            "message", ex.getMessage(),
            "details", ex.getDetails()
        ));
        return ResponseEntity.status(Integer.parseInt(ex.getCode())).body(errorResponse);
    }

}