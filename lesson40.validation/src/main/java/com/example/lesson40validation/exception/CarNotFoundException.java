package com.example.lesson40validation.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(int id) {
        super("Car with ID " + id + " not found");
    }
}