//package com.example.demo.ExceptionHandler;
//
//
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((org.springframework.validation.FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//        ErrorMessage errorMessage = new ErrorMessage();
//        errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        errorMessage.setTimeStamp(new Date());
//        errorMessage.setMessage("Validation error occurred");
//        errorMessage.setDescription(errors.toString());
//
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
//
//
//
////    @ExceptionHandler(BindException.class)
////    public ResponseEntity<Map<String, String>> handleBindException(BindException ex) {
////        Map<String, String> errors = new HashMap<>();
////        ex.getAllErrors().forEach((error) -> {
////            String fieldName = ((FieldError) error).getField();
////            String errorMessage = error.getDefaultMessage();
////            errors.put(fieldName, errorMessage);
////        });
////        return ResponseEntity.badRequest().body(errors);
////    }
////
////    @ExceptionHandler(DataIntegrityViolationException.class)
////    @ResponseBody
////    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
////        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data integrity violation: " + ex.getMessage());
////    }
////
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResponseEntity<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request){
////        Map<String,String> errors = new HashMap<>();
////        ex.getBindingResult().getAllErrors().forEach((error) -> {
////            String fieldName = ((org.springframework.validation.FieldError)error).getField();
////            String errorMessage = error.getDefaultMessage();
////            errors.put(fieldName, errorMessage);
////
////        });
////        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
////
////    }
//}
