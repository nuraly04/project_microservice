package com.example.project_microservice.exception;

public class DataValidationException extends RuntimeException {

    public DataValidationException(String message) {
        super(message);
    }
}
