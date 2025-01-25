package com.StudentManagement.management.customExceptions;

import org.springframework.http.HttpStatus;

public class CustomStudentNotFound extends RuntimeException {

//    private String msg;
    private HttpStatus status;

    public CustomStudentNotFound(String msg, HttpStatus status) {
        super(String.format(msg+status.toString()));
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
