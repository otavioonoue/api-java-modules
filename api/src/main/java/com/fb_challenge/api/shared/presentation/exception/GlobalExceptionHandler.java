package com.fb_challenge.api.shared.presentation.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fb_challenge.api.user.application.exception.DuplicatedKeyException;
import com.fb_challenge.api.user.application.exception.UserNotExistsException;
import com.fb_challenge.api.user.infrastructure.exception.InfrastructureException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
        MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(InfrastructureException.class)
    public ResponseEntity<Map<String, String>> handleInfrastructureValidationExceptions(
        InfrastructureException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("DATABASE_ERROR", ex.getMessage());

        return ResponseEntity.internalServerError().body(errors);
    }
    
    @ExceptionHandler(DuplicatedKeyException.class)
    public ResponseEntity<Map<String, String>> handleDuplicatedValidationExceptions(
        DuplicatedKeyException ex) {

        Map<String, String> errors = new HashMap<>();
        errors.put("DUPLICATED", ex.getMessage());

        return ResponseEntity.internalServerError().body(errors);
    }
    
    
    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<Void> UserExistsValidationExceptions(
        UserNotExistsException ex) {

        return ResponseEntity.notFound().build();
    }

}
