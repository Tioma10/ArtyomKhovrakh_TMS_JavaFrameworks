package com.example.xml.aspect;

public class LoggingAspect {
    public void beforeAdvice() {
        System.out.println("Before method (XML)");
    }

    public void afterAdvice() {
        System.out.println("After method (XML)");
    }
}