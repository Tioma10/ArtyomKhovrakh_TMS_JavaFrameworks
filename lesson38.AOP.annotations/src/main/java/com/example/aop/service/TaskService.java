package com.example.aop.service;

import com.example.aop.annotation.TrackTime;
import org.springframework.stereotype.Component;

@Component
public class TaskService {

    @TrackTime
    public void performTask() {
        System.out.println("Task is being performed...");
    }
}