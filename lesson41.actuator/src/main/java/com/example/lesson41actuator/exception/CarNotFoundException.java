package com.example.lesson41actuator.exception;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(int id) {
        super("Car with ID " + id + " not found");
    }
}
