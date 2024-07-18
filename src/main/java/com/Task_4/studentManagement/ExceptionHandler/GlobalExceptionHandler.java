package com.Task_4.studentManagement.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<com.example.demo.ExceptionHandler.ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        com.example.demo.ExceptionHandler.ErrorMessage errorMessage = new com.example.demo.ExceptionHandler.ErrorMessage();
        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimeStamp(new Date());
        errorMessage.setMessage("Validation error occurred");
        errorMessage.setDescription(errors.toString());

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(com.example.demo.ExceptionHandler.ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(com.example.demo.ExceptionHandler.ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//        ErrorMessage errorMessage = new ErrorMessage(
//                HttpStatus.NOT_FOUND.value(),
//                new Date(),
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//
//        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
