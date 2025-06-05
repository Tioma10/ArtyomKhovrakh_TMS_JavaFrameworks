package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class TaskService {

    @TrackTime
    public void performTask() {
        System.out.println("Task is being performed...");
    }
}