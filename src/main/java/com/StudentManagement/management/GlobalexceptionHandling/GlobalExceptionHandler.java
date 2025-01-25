package com.StudentManagement.management.GlobalexceptionHandling;

import com.StudentManagement.management.customExceptions.CustomStudentNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomStudentNotFound.class)
    public ResponseEntity<CustomStudentNotFound> studentNotFound(CustomStudentNotFound e){
        return new ResponseEntity<CustomStudentNotFound>(e,e.getStatus());
    }
}
