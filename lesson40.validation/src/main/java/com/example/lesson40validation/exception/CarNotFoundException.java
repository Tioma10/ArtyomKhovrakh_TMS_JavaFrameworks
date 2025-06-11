package com.example.lesson40validation.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(int id) {
        super("Car with ID " + id + " not found");
    }
}