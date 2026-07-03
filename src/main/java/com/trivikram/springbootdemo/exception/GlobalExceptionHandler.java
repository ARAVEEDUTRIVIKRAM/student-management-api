package com.trivikram.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
    // THis says when ever StudentNotFoundException happens Run this method
    @ExceptionHandler(StudentNotFoundException.class)

    // ResponseEntity ( It return all HTTP Responses) Contains all http body data like http status codes ( 404, 200, 201 etc..) and the exact date and time
    public ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException ex){
        // Creating a empty map to store all the responses form response entity
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("time", LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    // THIS IS FOR THE WHEN METHOD ARGUMGENT NOT VALID , LIKE WHEN THIS HAPPENS(MANVE(MET ARG NOT VAL EXP) RUN THIS CLASS. LIKE WHEN THE FILED IS SET TO NOT NULL TO THE NAME BUT YOU ENDED UP BEING RETURN EMPTY NAME, THEN THE COMPILER THOROWS THIS " MethodArgumentNotValidException " error and this method will handle that error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();


        // The BindingResult Contains all validation results.
        // The FieldError Give the filed errors ( fileds means Name, email , title etc....)
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
